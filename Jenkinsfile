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
    stage("upload artifacts"){
      steps{
        script{
           def pom = readMavenPom file: 'pom.xml'
           def version = pom.version
           def repoName = veriosn.endswith("SNAPSHOT") ? "do-snapshot": "do-release"
           nexusArtifactUploader artifacts: [[artifactId: 'doctor-online', classifier: '', file: 'target/doctor-online.war', type: 'war']], 
             credentialsId: 'Nexus', 
             groupId: 'in.javahome', 
             nexusUrl: '172.31.32.247:8081', 
             nexusVersion: 'nexus3', 
             protocol: 'http', 
             repository: repoName, 
             version: version
        }
      }
    }
    stage("tomcat deploy"){
      steps{
        TomcatDeploy("54.196.216.101","172.31.21.235",'ec2-user','doctor-online.war')
      }
    }
  }
}
