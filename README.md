# Insurance Claim Platform

A cloud-native insurance claim management platform built using microservices architecture with secure authentication, containerized deployment, and CI/CD automation for streamlined build and deployment workflows.

## Features

* User authentication with AWS Cognito
* Role-based access control
* Insurance offers management
* Claims creation and tracking
* Scalable microservices architecture
* Automated CI/CD pipeline using GitHub Actions

## Tech Stack

* Spring Boot
* MongoDB
* Docker
* Kubernetes
* AWS Cognito
* GitHub Actions
* AWS (EKS/ECR)

## CI/CD Pipeline

Implemented GitHub Actions workflow for:

* Automated build and testing
* Docker image creation
* Push to AWS ECR
* Deployment to Kubernetes (EKS)

## Architecture

```text
Client → API Gateway → Microservices → MongoDB
                     ↓
               AWS Cognito
                     ↓
         GitHub Actions CI/CD Pipeline
                     ↓
              AWS EKS / ECR
```

## Services

* Auth Service
* Offer Service
* Claim Service

## Security

* JWT Authentication
* AWS Cognito Integration
* Role-Based Authorization
