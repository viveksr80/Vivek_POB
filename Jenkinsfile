pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
  }
  parameters {
    string(name: 'WORKSPACE_NAME', defaultValue: 'MySecondWebDriverProject', description: 'Who should I say hello to?')
    string(name: 'PROJECT_NAME', defaultValue: 'MySecondWebDriverProject', description: 'Who should I say hello to?')
    string(name: 'url1', defaultValue: 'http://asic.demo@52.19.50.152/gerrit/ExampleWorkspace/ExampleProject/spring-petclinic', description: 'Gerrit url')
  }
  stages {
    stage('Start') {
      steps {
        echo 'Pipeline started...'
        echo 'Build Number: ' + env.BUILD_NUMBER
      }
    }
      stage('App_Build_ST') {
        steps {
		echo 'Build Number: ' + env.BUILD_NUMBER
      }
    }
    stage('Unit_Tests_ST') {
      steps {
        echo 'Unit_Tests_ST Testing...'
        echo 'Build Number: ' + env.BUILD_NUMBER
        deleteDir()
      }
    }
    stage('Code_Analysis_ST') {
      steps {
        echo 'Code_Analysis_ST...'
        echo 'Build Number: ' + env.BUILD_NUMBER
      }
    }
    stage('Deploy_Environment_ST') {
      steps {
        echo 'Deploy_Environment_ST...'
		echo 'Build Number: ' + env.BUILD_NUMBER
      }
    }
    stage('Test_Build_ST') {
      steps {
        node(label: 'All_NT') {
            git(url: 'http://asic.demo@52.19.50.152/gerrit/BlueOceanProject', branch: 'master', credentialsId: 'asic.demo/Ready2work')
            //checkout scm
            bat([script:"${tool 'ADOP Maven'}/bin/mvn clean compile install -DskipTests"])
            archiveArtifacts artifacts: '**/*'
		}
      }
    }
    stage('Continuous_Testing_ST') {
      steps {
        parallel(
          "01_Functional_Tests_ST": {
            echo 'Functional Testing...'
            
          },
          "02-Platform_Tests_ST": {
            echo 'Platform Testing...'
            
          },
          "03_BDD_Regression_Tests_ST": {
            echo 'BDD Testing...'
            
          },
          "04-API_Tests_ST": {
            echo ' API Testing...'
          }
        )
      }
    }
    stage('End') {
      steps {
        echo 'Pipeline ended...'
      }
    }
  }
  post {
    always {
      echo 'I will always say Hello again!'
    }
  }
}
