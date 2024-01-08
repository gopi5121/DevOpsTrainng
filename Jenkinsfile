@Library('shared-libraries') _
pipeline{
  agent any
  stages{
    stage('main'){
      when{branch "main"}
      steps{
        echo"this is an main branch" 
      }
    }
    stage('develop'){
      when{branch "develop"}
      steps{
        echo 'this is an develop branch'
      }
    }
    stage("tomcat deploy"){
      when{branch "test"}
      steps{
        echo "this is an test branch"
      }
    }
  }
}
