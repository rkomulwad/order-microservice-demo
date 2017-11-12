FROM cassandra:latest

VOLUME /tmp

ADD init.cql init.cql

ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh wait-for-it.sh
RUN sh -c 'chmod +x wait-for-it.sh'
