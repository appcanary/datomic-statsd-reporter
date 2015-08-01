# datomic-statsd-reporter

A tiny clojure library that reports datomic metrics to statsd. This is heavily inspired by [Tom Crayford](https://github.com/tcrayford)'s [datomic-riemann-reporter](https://github.com/yeller/datomic-riemann-reporter/).

## Usage

Drop an uberjar in $DATOMIC_DIR/lib, then add this to your transactor's `properties` file:

```ini
metrics-callback=datomic-statsd-reporter/report-datomic-metrics-to-statsd
```

Then you need to set these two environment variables:

```
STATSD_HOST=your_statsd_host
STATSD_PORT=port
```

If you don't set these variables, the defaults are port 8125 on 127.0.0.1.

Then restart your transactor, and you'll see events showing up in riemann. All
events will be tagged "datomic", and start with "datomic". Event names come
from the metrics available on http://docs.datomic.com/monitoring.html.

## License

Copyright © 2015 Canary Computer Corporation

Distributed under the Apache License version 2.0
