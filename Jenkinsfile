pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
  }
  stages {
    stage('App_Build_ST') {
        steps {
			echo 'Build Number: ' + env.BUILD_NUMBER
			node(label: 'java8') {
				git(url: 'https://github.com/viveksr80/PetClinic.git', branch: 'master', credentialsId: '')
            	sh([script:"${tool 'ADOP Maven'}/bin/mvn compile -DskipTests"])
            	archiveArtifacts artifacts: '**/*'
			}
      	}
    }
    stage('Unit_Tests_ST') {
      steps {
		node(label: 'java8') {
        	echo 'Build Number: ' + env.BUILD_NUMBER
			sh([script:"${tool 'ADOP Maven'}/bin/mvn clean test"])
			archiveArtifacts artifacts: '**/*' 
		}
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
		node(label:'docker'){
			echo 'Deploy_Environment_ST...'
			echo 'Build Number: ' + env.BUILD_NUMBER
				
			archiveArtifacts artifacts: '**/*' 
			
			echo WORKSPACE

		}
      }
    }
    stage('Test_Build_ST') {
      steps {
		node(label: 'All_NT') {
			deleteDir()
			git(url: 'https://github.com/viveksr80/Vivek_POB.git', branch: 'master', credentialsId: '')
			bat([script:"${tool 'ADOP Maven'}/bin/mvn clean compile install -DskipTests"])
		}
      }
    }
	stage('Continuous_Testing_ST') {
	steps {
	  parallel(
		"01-Functional": {
			echo 'Functional Testing...'
			node(label: 'All_NT') {
				bat([script:'set MAVEN_OPTS = –Xmx2048m'])
				bat([script:'mvn exec:java -X -Dexec.mainClass="com.accenture.runner.selenium.SELENIUM_Executor" -Dexec.classpathScope=test'])
			}
		},
          "02-Platform": {
            echo 'Platform Testing...'
			node(label: 'All_NT') {
				bat([script:'mvn exec:java -X -Dexec.mainClass="com.accenture.runner.platform.PLATFORM_Executor" -Dexec.classpathScope=test'])
			}
        },
          "03-BDD": {
            echo 'BDD Testing...'
			node(label: 'All_NT') {
				bat([script:'mvn exec:java -X -Dexec.mainClass="com.accenture.runner.bdd.BDD_Executor" -Dexec.classpathScope=test'])
			}
        },
          "04-API": {
            echo ' API Testing...'
			node(label: 'All_NT') {
				bat([script:'start /b mvn jetty:run'])
				bat([script:'mvn integration-test'])
				bat([script:'mvn jetty:stop'])
			}
        }
        )
      }
    }
    stage('Pre-Prod-Deploy') {
      steps {
        echo 'Pre-Prod-Deployment started...'
      }
    }
  }
  post {
    always {
      echo 'Post Build Step'
    }
  }
}
