
IMAGE_NAME=quay.io/paulbarrie7/trademe
IMAGE_TAG=latest
TEST_TAG=1.0.0-test

build:
	docker build -f Dockerfile -t $(IMAGE_NAME):$(IMAGE_TAG) .
.PHONY: build

deploy:
	docker push $(IMAGE_NAME):$(IMAGE_TAG)
.PHONY: deploy

rmi:
	docker rmi $(IMAGE_NAME):$(IMAGE_TAG)
.PHONY: rmi

run:
	docker run -it --rm -p 8080:8080 $(IMAGE_NAME):$(IMAGE_TAG)
.PHONY: run

test:
	$(MAKE) build IMAGE_TAG=$(TEST_TAG)
	docker run --entrypoint=mvn $(IMAGE_NAME):$(TEST_TAG) test
.PHONY: test

deploy:
	docker push $(IMAGE_NAME):$(TEST_TAG)
.PHONY: deploy

debug:
	docker run -ti --entrypoint=sh quay.io/paulbarrie7/trademe:1.0.0
.PHONY: debug