package com.birbit.android.jobqueue.messaging;

import com.birbit.android.jobqueue.messaging.message.*;

import java.util.HashMap;
import java.util.Map;

/**
 * All message types
 */
public enum Type {
    CALLBACK(CallbackMessage.class, 0),
    CANCEL_RESULT_CALLBACK(CancelResultMessage.class, 0),
    RUN_JOB(RunJobMessage.class, 0),
    COMMAND(CommandMessage.class, 0),
    PUBLIC_QUERY(PublicQueryMessage.class, 0),
    JOB_CONSUMER_IDLE(JobConsumerIdleMessage.class, 0), // MUST ARRIVE AFTER JOB RESULT
    CANCEL_BY_ID(CancelByIdMessage.class, 0),
    ADD_JOB(AddJobMessage.class, 1),
    CANCEL(CancelMessage.class, 1),
    CONSTRAINT_CHANGE(ConstraintChangeMessage.class, 2),
    RUN_JOB_RESULT(RunJobResultMessage.class, 3),
    SCHEDULER(SchedulerMessage.class, 4);
    final Class<? extends Message> klass;
    final static Map<Class<? extends Message>, Type> mapping;
    final int priority; // higher is better
    final static int MAX_PRIORITY;

    Type(Class<? extends Message> klass, int priority) {
        this.klass = klass;
        this.priority = priority;
    }
    static {
        int maxPriority = 0;
        mapping = new HashMap<>();
        for (Type type : Type.values()) {
            mapping.put(type.klass, type);
            if (type.priority > maxPriority) {
                maxPriority = type.priority;
            }
        }
        MAX_PRIORITY = maxPriority;
    }
}
