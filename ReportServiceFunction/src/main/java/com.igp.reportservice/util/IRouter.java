package com.igp.reportservice.util;

import com.amazonaws.services.lambda.runtime.Context;

@FunctionalInterface
public interface IRouter<I, O, S extends IService> {
    O route(I event, Context context, S service);
}
