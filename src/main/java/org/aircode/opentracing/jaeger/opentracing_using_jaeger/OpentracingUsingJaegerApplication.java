package org.aircode.opentracing.jaeger.opentracing_using_jaeger;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.reporters.InMemoryReporter;
import io.jaegertracing.internal.samplers.ConstSampler;
import io.jaegertracing.spi.Reporter;
import io.jaegertracing.spi.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpentracingUsingJaegerApplication {

	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		final Reporter reporter = new InMemoryReporter();
		final Sampler sampler = new ConstSampler(false);
		return new JaegerTracer.Builder("open-tracing-poc")
				.withReporter(reporter)
				.withSampler(sampler)
				.build();
	}

		public static void main(String[] args) {
		SpringApplication.run(OpentracingUsingJaegerApplication.class, args);
	}

}
