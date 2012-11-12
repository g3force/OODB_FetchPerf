OODB_FetchPerf
==============

Demo: Fetch Performance, Standard vs. Eclipselink Spezifika

Prepare database, if you like:
- run tpch-sf0.5.sh to load tpch with scale factor 0.5 (db and tables should exist, just data is truncated and loaded)

Benchmark Results:
- run "mountBenchmark.sh" (or run external tool in eclipse)
- visit http://localhost/benchmark/ (or run external tool "Benchmark Result" in eclipse)
- choose

We used the junit benchmark framework from carrotsearch:
http://labs.carrotsearch.com/junit-benchmarks.html