package org.aircode.opentracing.jaeger.opentracing_using_jaeger;

import io.opentracing.Span;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @Autowired
    private io.opentracing.Tracer jaegerTracer;

    @RequestMapping("/hello")
    public String hello() {
        Span span = jaegerTracer.buildSpan("hello").start();
        jaegerTracer.activateSpan(span);
        jaegerTracer.activeSpan().setTag("operation", "hello");
        jaegerTracer.activeSpan().setTag("type", "GET");
        jaegerTracer.activeSpan().log("Hello Iron Man");
        return "Hello Iron Man";
    }
}
