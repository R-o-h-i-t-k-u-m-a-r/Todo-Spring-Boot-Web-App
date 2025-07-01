pipeline {
    agent any
    tools{
        maven 'maven'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'd3efd4ee-668b-494d-9f51-2ff51d37e5da', url: 'https://github.com/R-o-h-i-t-k-u-m-a-r/Todo-Spring-Boot-Web-App.git']])
                bat 'mvn clean install' 
            }
        }
        stage('Build docker image'){
            steps{
                 script{
                     bat 'docker build -t rohitkumar65108/docker-jenkins-integration-sample .'
                 }
            }
        }
        stage('push dokcer image to docker hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhubcred', variable: 'dockerhubpassword')]) {
                        bat 'docker login -u rohitkumar65108 -p ${dockerhubpassword}'
                    }
                    bat 'docker push rohitkumar65108/docker-jenkins-integration-sample:latest'
                }
                
            }
        }
    }
}
