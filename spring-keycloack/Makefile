run_keycloack:
	sudo docker run --rm -d -p 9090:8080 --name keyclock_local -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:17.0.0 start-dev



all: run_keycloack
