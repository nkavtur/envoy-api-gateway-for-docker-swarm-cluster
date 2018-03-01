FROM envoyproxy/envoy:latest
RUN apt-get update
COPY envoy/envoy-proxy.yaml /etc/
CMD ["/usr/local/bin/envoy", "-c", "/etc/envoy-proxy.yaml"]
