
```FileBeat
cp filebeat.yml ../../Log-Streaming/filebeat/

```Flog
flog -t log -o ../log/apache.log -n 3000 -d 1s -w

```Kafka-Connect
docker-compose up -b

```Ansible
cd ansible/POC/
eval `ssh-agent -s`
ssh-add /root/ansible/POC/.ssh/ssh-private
ansible-playbook -v --vault-password-file ~/ansible/vault/passwd -i /root/ansible/INVEX/hosts playbooks/sync-logs.yml

```Fluentd
docker-compose up -b

```Syncer
./gradlew bootRun --args='-Dspring.profiles.active=local'


The following diagram illustrates the architecture for the solution:

