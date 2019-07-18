package org.aircode.opentracing.jaeger.opentracing_using_jaeger;

import io.jaegertracing.Configuration;
import io.jaegertracing.internal.JaegerSpan;
import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.reporters.InMemoryReporter;
import io.jaegertracing.internal.reporters.NoopReporter;
import io.jaegertracing.internal.samplers.ConstSampler;
import io.jaegertracing.internal.samplers.ProbabilisticSampler;
import io.jaegertracing.spi.Reporter;
import io.jaegertracing.spi.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class OpentracingUsingJaegerApplication {

	@Bean
	public io.opentracing.Tracer jaegerTracer() {

		if (Boolean.valueOf(System.getenv("JAEGER_ENABLED"))) {
			return Configuration.fromEnv().getTracer();
		}
		else {
			Reporter reporter = new NoopReporter();
			Sampler sampler = new ProbabilisticSampler(1.0);
			return new JaegerTracer.Builder("jaeger-poc")
					.withReporter(reporter)
					.withSampler(sampler)
					.build();
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(OpentracingUsingJaegerApplication.class, args);
	}

}
