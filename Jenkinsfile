pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
  }
  parameters {
    string(name: 'WORKSPACE_NAME', defaultValue: 'MySecondWebDriverProject', description: 'Who should I say hello to?')
    string(name: 'PROJECT_NAME', defaultValue: 'MySecondWebDriverProject', description: 'Who should I say hello to?')
    //string(name: 'url1', defaultValue: 'http://asic.demo:Ready2work@52.19.50.152/gerrit/ExampleWorkspace/ExampleProject/spring-petclinic', description: 'Gerrit url')
  }
  stages {
    stage('Start') {
      steps {
        echo 'Testing...'
        echo '${env.BUILD_NUMBER}'
      }
    }
      stage('App_Build_ST') {
        steps {
		    node(label: 'java8') {
			echo "${params.url1}"
			git(url: 'http://asic.demo@52.19.50.152/gerrit/ExampleWorkspace/ExampleProject/spring-petclinic' branch: 'master', credentialsId: 'asic.demo/Ready2work')
            checkout scm
            sh([script:"${tool 'ADOP Maven'}/bin/mvn compile -DskipTests"])
            //sh "mvn clean install -Dmaven.test.failure.ignore=true"
            archiveArtifacts artifacts: '**/*'
            
        }
      }
    }
    stage('Unit_Tests_ST') {
      steps {
        echo 'Unit_Tests_ST Testing...'
        echo '${env.BUILD_NUMBER}'
        deleteDir()
      }
    }
    stage('Code_Analysis_ST') {
      steps {
        echo 'Code_Analysis_ST Testing...'
        echo '${env.BUILD_NUMBER}'
      }
    }
    stage('Deploy_Environment_ST') {
      steps {
        echo 'Testing Deploy_Environment_ST'
      }
    }
    stage('Test_Build_ST') {
      steps {
        node(label: 'All_NT') {
            git(url: 'http://asic.demo@52.19.50.152/gerrit/BlueOceanProject', branch: 'master', credentialsId: 'asic.demo/Ready2work')
            checkout scm
            bat([script:"${tool 'ADOP Maven'}/bin/mvn clean compile install -DskipTests"])
            archiveArtifacts artifacts: '**/*'
      }
      }
    }
    stage('Continuous_Testing_ST') {
      steps {
        parallel(
          "Continuous_Testing_ST": {
            echo 'Testing...'
            
          },
          "01_Functional_Tests_ST": {
            echo 'Functioanl'
            
          },
          "02-Platform_Tests_ST": {
            echo 'Functioanl'
            
          },
          "03_BDD_Regression_Tests_ST": {
            echo 'Testing BDD'
            
          },
          "04-API_Tests_ST": {
            echo 'Testing...'
            
          }
        )
      }
    }
    stage('End') {
      steps {
        echo 'End'
      }
    }
  }
  post {
    always {
      echo 'I will always say Hello again!'
    }
  }
}
