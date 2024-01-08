@Library('shared-libraries') _
pipeline{
  agent any
  stages{
    stage('code checkout'){
      steps{
        git branch: 'main', credentialsId: 'github', url: 'https://github.com/gopi5121/doctor-online'
      }
    }
    stage('maven build'){
      steps{
        sh "mvn clean package"
      }
    }
    stage("tomcat deploy"){
      steps{
        TomcatDeploy("54.196.216.101","172.31.21.235",'ec2-user','doctor-online.war')
      }
    }
  }
}
