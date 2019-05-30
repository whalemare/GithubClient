package ru.ivanova.githubclient;

import ru.ivanova.githubclient.utils.SimpleObserver;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

/**
 * Created by Irina Ivanova on 28.05.19.
 */
public class HeavyLibraryWrapper {

    private HeavyExternalLibrary heavyExternalLibrary;

    private boolean isInitialized = false;

    ConnectableObservable<HeavyExternalLibrary> initObservable;

    public HeavyLibraryWrapper() {
        initObservable = Observable.create(new Observable.OnSubscribe<HeavyExternalLibrary>() {
            @Override
            public void call(Subscriber<? super HeavyExternalLibrary> subscriber) {
                HeavyLibraryWrapper.this.heavyExternalLibrary = new HeavyExternalLibrary();
                HeavyLibraryWrapper.this.heavyExternalLibrary.init();
                subscriber.onNext(heavyExternalLibrary);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).publish();

        initObservable.subscribe(new SimpleObserver<HeavyExternalLibrary>() {
            @Override
            public void onNext(HeavyExternalLibrary heavyExternalLibrary) {
                isInitialized = true;
            }
        });

        initObservable.connect();
    }

    public void callMethod() {
        if (isInitialized) {
            heavyExternalLibrary.callMethod();
        } else {
            initObservable.subscribe(new SimpleObserver<HeavyExternalLibrary>() {
                @Override
                public void onNext(HeavyExternalLibrary heavyExternalLibrary) {
                    heavyExternalLibrary.callMethod();
                }
            });
        }
    }
}