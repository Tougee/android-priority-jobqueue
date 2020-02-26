package com.birbit.android.jobqueue.messaging.message;

import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.Type;

public class CancelByIdMessage extends Message {
    private String id;

    private Callback callback;

    public CancelByIdMessage() {
        super(Type.CANCEL_BY_ID);
    }

    @Override
    protected void onRecycled() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {
        void onCancelled();
    }
}