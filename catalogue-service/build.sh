eval $(minikube -p minikube docker-env)

mvn clean install spring-boot:build-image
docker push fabricio211/catalogue-service:0.0.1-SNAPSHOT

kubectl create ns spring
kubectl config set-context --current --namespace=spring
kubectl apply -f catalogue-k8s-deployment.yml
