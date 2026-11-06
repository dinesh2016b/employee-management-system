package com.online.ems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;

@Component
public class GatewayLoggingFilter implements GlobalFilter, Ordered {

	private static final Logger logger = LoggerFactory.getLogger(GatewayLoggingFilter.class);

	@Override
	public reactor.core.publisher.Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("request uri -> {}", exchange.getRequest().getURI());
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
