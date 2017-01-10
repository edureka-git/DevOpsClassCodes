<?xml version="1.0" encoding="UTF-8"?>
<!-- ====================================================================== -->
<!-- Ant build file (http://ant.apache.org/) for Ant 1.7.2 or above.        -->
<!-- ====================================================================== -->

<project name="addressbook" default="zip" basedir="." xmlns:artifact="antlib:org.apache.maven.artifact.ant" xmlns:ac="antlib:net.sf.antcontrib"   xmlns:sonar="antlib:org.sonar.ant">
	<tstamp><format property="MYTIME" pattern="yyyyMMddHHmmss" /></tstamp>

	 <!-- ====================================================================== -->
	 <!-- Defining classpaths & Task Defs                                        -->
	 <!-- ====================================================================== -->
	<property environment="env"/> 
	<property name="installpath.pmd" value="${env.PMD_HOME}/lib"/> 
	<property name="pmd.installpath" value="${env.PMD_HOME}/lib"/>
	<property name="pmd.classpath" value="${env.PMD_HOME}/lib"/>
	  <!-- For Cobertura --> 
	  <property name="lib.cobertura.dir" value="c:/apps/cobertura-1.9.4.1" />
	  <property name="cobertura.jar.file" value="${lib.cobertura.dir}/cobertura.jar" />
		<path id="pmd.classpath">
				<fileset dir="${pmd.installpath}"/>
		</path>
		<taskdef name="pmd" classname="net.sourceforge.pmd.ant.PMDTask" classpathref="pmd.classpath"/>
		<path id="maven-ant-tasks.classpath" path="${ant.home}/lib/maven-ant-tasks-2.1.3.jar" />
		  <typedef resource="org/apache/maven/artifact/ant/antlib.xml"
		       uri="antlib:org.apache.maven.artifact.ant"
		       classpathref="maven-ant-tasks.classpath" />
		<path id="ant.contrib.classpath" path="${ant.home}/lib/ant-contrib.jar"/>
		<typedef resource="net/sf/antcontrib/antlib.xml" classpathref="ant.contrib.classpath"/>


  <!-- ====================================================================== -->
  <!-- Build environment properties                                           -->
  <!-- ====================================================================== -->
   <property name="environment.type.default" value="dev"/>
  	<if>
  					 <equals arg1="${basesrcdir}" arg2="$${basesrcdir}"/>
  					 <then>
  					 	<property name="build.basesrcdir" value="."/>
  					</then> 
  					 	<else>
  					 		<property name="build.basesrcdir" value="${basesrcdir}"/>
  					    </else>
  	</if>
  	<if>
  					 <equals arg1="${buildtype}" arg2="$${buildtype}"/>
  					 <then>
					 		<property name="maven.build.resourceDir" value="${build.basesrcdir}/src/main/resources/${environment.type.default}"/>
  					 	<property name="actualbuildtype" value="${environment.type.default}"/>
  					</then> 
  					 	<else>
  					 		<property name="maven.build.resourceDir" value="${build.basesrcdir}/src/main/resources/${buildtype}"/>
  	  					 	<property name="actualbuildtype" value="${buildtype}"/>
  					    </else>
  	</if>
	<echo message="resource dir: ${maven.build.resourceDir}, Source Dir: ${build.basesrcdir}/src/main/java"/>
   <property file="${build.basesrcdir}/build.properties"/>
   <artifact:pom id="pom" file="pom.xml" />
   <property name="actualbuildname" value="${pom.artifactId}"/>
   <property name="actualversion" value="${pom.version}"/>	
   <echo message="Artifact ID/Version: ${actualbuildname}/${actualversion}"/>
   <property name="build.version" value="${version}"/>
   <property name="maven.build.finalName" value="${actualbuildname}-${actualversion}"/>
   <property name="maven.build.dir" value="${build.basesrcdir}/target"/>
   <property name="maven.build.outputDir" value="${maven.build.dir}/classes"/>
   <property name="maven.build.srcDir" value="${build.basesrcdir}/src/main/java"/>
   <property name="maven.build.testDir" value="${build.basesrcdir}/src/test/java"/>
   <property name="maven.build.testResourceDir" value="${build.basesrcdir}/src/test/resources"/>
   <property name="maven.build.testOutputDir" value="${maven.build.dir}/test-classes"/>
   <property name="maven.test.reports" value="${maven.build.dir}/test-reports"/>
   <property name="maven.reporting.outputDirectory" value="reports"/>
   <property name="project.3rdpartylibdir" value="${build.basesrcdir}/lib"/>
   <property name="maven.build.pmddir" value="${build.basesrcdir}/src/main/pmd"/> 
   <property name="sonar.host.url" value="${env.SONAR_URL}" /> 
   <property name="sonar.jdbc.url"  value="jdbc:mysql://${env.SONAR_DBSERVER}:${env.SONAR_DBPORT}/${env.SONAR_DBNAME}?useUnicode=true&amp;characterEncoding=utf8&amp;rewriteBatchedStatements=true&amp;useConfigs=maxPerformance" />
   <property name="sonar.jdbc.username"  value="${env.SONAR_DBUSER}"/> 
   <property name="sonar.jdbc.password"  value="${env.SONAR_DBPASSWORD}"/> 
   <property name="sonar.projectKey" value="${ant.project.name}"/>
   <property name="sonar.projectName" value="${ant.project.name}"/>
   <property name="sonar.projectVersion" value="${actualversion}"/>
   <property name="sonar.sources" value="${build.basesrcdir}/src/main/java"/>
   <!-- For Cobertura --> 
   <property name="cob.ser.file" value="cobertura.ser" />
   <property name="cobertura.dir" value="./cobertura" />
   <property name="cob.instrumented.dir" value="${cobertura.dir}/instrumented" />
   <property name="cob.reports.dir" value="${cobertura.dir}/reports" />
   <property name="cob.reports.xml.dir" value="${cob.reports.dir}/junit-xml" />
   <property name="cob.reports.html.dir" value="${cob.reports.dir}/junit-html" />
   <property name="cob.coverage.xml.dir" value="${cob.reports.dir}/cobertura-xml" />
   <property name="cob.coverage.html.dir" value="${cob.reports.dir}/cobertura-html" />

	
	<path id="libpath">
		<fileset dir="${project.3rdpartylibdir}"/>
	</path>
	<path id="build.test.classpath">
			<pathelement location="${project.3rdpartylibdir}/junit-4.11.jar"/>
	</path>

   <echo message="***************************************************************************"/>
   <echo message="Start the build for: ${ant.project.name} "/>
   <echo message="Base Dir: ${build.basesrcdir} ${actualbuildtype}"/> 
   <mkdir dir="${project.3rdpartylibdir}"/>
   <echo message="PMD Libraries installed in: ${pmd.installpath}"/>
   <echo message="***************************************************************************"/>
   <echo message="Skip Test? ${maven.test.skip}"/>

		
  <!-- ====================================================================== -->
  <!-- Cleaning up target                                                     -->
  <!-- ====================================================================== -->
  <target name="clean" description="Clean the output directory">
		<delete dir="${maven.build.dir}"/>
		<delete dir="${project.3rdpartylibdir}"/>
		<delete dir="${maven.reporting.outputDirectory}"/>
  	    <delete dir="./.sonar"/> 
  	    <delete dir="reports"/>
  	    <delete file="${cob.ser.file}"/>
  	    <delete dir="${cobertura.dir}"/>
  </target>

   <!-- ======================================================================  -->
	<!-- Copy Maven dependencies                                                -->
	<!-- ====================================================================== -->
	<target name="maven_dep_copy" depends="clean" description="Copies Maven Dependencies into local Lib folder">
	 <artifact:dependencies filesetId="deps.fileset" scopes="provided, test, runtime, compile">
	      <pom file="pom.xml"/>
	    </artifact:dependencies>
	<mkdir dir="${project.3rdpartylibdir}"/>
	<copy todir="${project.3rdpartylibdir}">
	  <fileset refid="deps.fileset" />
		<mapper type="flatten" />
	</copy>
</target> 
	
  <!-- ====================================================================== -->
  <!-- Compilation target                                                     -->
  <!-- ====================================================================== -->
  <target name="compile" depends="maven_dep_copy" description="Compiles the code. Does a validation on PMD Rules">
    <mkdir dir="${maven.build.outputDir}"/>
    <javac includeantruntime="false" destdir="${maven.build.outputDir}" 
           nowarn="false"            debug="true" 
           optimize="false"         deprecation="true" 
           target="1.6"                   verbose="false" 
           fork="false"                  source="1.6">
      <src>
        <pathelement location="${maven.build.srcDir}"/>
      </src>
      <classpath>
      		<fileset dir="${project.3rdpartylibdir}"/>
      </classpath>
    </javac>
    <copy todir="${maven.build.outputDir}">
      <fileset dir="${maven.build.resourceDir}"/>
    </copy>
  </target>

  <!-- ====================================================================== -->
  <!-- Test-compilation target                                                -->
  <!-- ====================================================================== -->
  <target name="compile-tests" 
          depends="compile" 
          description="Compiles the test code, unless maven's skip test property is unset">
    <mkdir dir="${maven.build.testOutputDir}"/>
    <javac includeantruntime="false" destdir="${maven.build.testOutputDir}" 
           nowarn="false"           debug="true" 
           optimize="false"        deprecation="true" 
           target="1.8"                  verbose="false" 
           fork="false"                 source="1.7">
      <src>
        <pathelement location="${maven.build.testDir}"/>
      </src>
	        <classpath>
      		<fileset dir="${project.3rdpartylibdir}"/>
			<pathelement location="${maven.build.outputDir}"/>
	        <fileset dir="${lib.cobertura.dir}"/>
      </classpath>
    </javac>
    <copy todir="${maven.build.testOutputDir}">
      <fileset dir="${maven.build.testResourceDir}"/>
    </copy>
  </target>

  <!-- ====================================================================== -->
  <!-- Run all tests                                                          -->
  <!-- ====================================================================== -->
  <target name="test" 
          depends="compile-tests" 
          description="Runs the test cases">
    <mkdir dir="${maven.test.reports}"/>
    <junit haltonerror="no" failureproperty="test.failed" haltonfailure="no" printSummary="yes"  fork="true" dir=".">
      <sysproperty key="basedir" value="."/>
      <formatter type="xml"/>
      <formatter type="plain" usefile="false"/>
     <classpath>
     	<fileset dir="${project.3rdpartylibdir}"/>
        <pathelement location="${maven.build.outputDir}"/>
        <pathelement location="${maven.build.testOutputDir}"/>
      </classpath>
      <batchtest skipNonTests="false" todir="${maven.test.reports}">
        <fileset dir="${maven.build.testDir}">
          <include name="**/Test*.java"/>
          <include name="**/*Test.java"/>
          <include name="**/*TestCase.java"/>
          <exclude name="**/*Abstract*Test.java"/>
        </fileset>
      </batchtest>
    </junit>
  	
    <junitreport todir="${maven.test.reports}">
         <fileset dir="${maven.test.reports}">
             <include name="TEST-*.xml" />
         </fileset>
         <report format="noframes" todir="${maven.test.reports}\html\" />
     </junitreport>
  	
    <fail message="Test failure detected, check test results." if="test.failed" />
  </target>

  <target name="test-junit-present" description="Checks if JUNIT is present">
    <available classname="junit.framework.Test" property="junit.present" classpathref="build.test.classpath"/>
  	<echo message="${junit.present}"/>
  </target>

  <target name="test-junit-status" 
          depends="test-junit-present" description="Set condition if JUNIT tests are to be run.">
    <condition property="junit.missing">
      <and>
        <isfalse value="${junit.present}"/>
        <isfalse value="${maven.test.skip}"/>
      </and>
    </condition>
    <condition property="junit.skipped">
      <or>
        <isfalse value="${junit.present}"/>
        <istrue value="${maven.test.skip}"/>
      </or>
    </condition>
  </target>

  <target name="junit-missing" 
          depends="test-junit-status" 
          if="junit.missing" description="Reports if JUNIT library is missing so to avoid running JUNIT Tests">
    <echo>=================================== WARNING ==========================================</echo>
    <echo> JUnit is not present in the test classpath or your $ANT_HOME/lib directory. Tests not executed.  </echo>
    <echo>=======================================================================================</echo>
  </target>

  <!-- ====================================================================== -->
  <!-- Javadoc target                                                         -->
  <!-- ====================================================================== -->
  <target name="javadoc" description="Generates the Javadoc of the application">
    <javadoc sourcepath="${maven.build.srcDir}" 
             packagenames="*" 
             destdir="${maven.reporting.outputDirectory}/apidocs" 
             access="protected" 
             old="false" 
             verbose="false" 
             version="true" 
             use="true" 
             author="true" 
             splitindex="false" 
             nodeprecated="false" 
             nodeprecatedlist="false" 
             notree="false" 
             noindex="false" 
             nohelp="false" 
             nonavbar="false" 
             serialwarn="false" 
             charset="ISO-8859-1" 
             linksource="false" 
             breakiterator="false"
             additionalparam="-Xdoclint:none" />
  </target>

	  <!-- ====================================================================== -->
	  <!-- PMD Report                                                             -->
	  <!-- ====================================================================== -->
		<target name="pmdreport" description="Generates PMD Reported issues list as a browsable HTML">
		<mkdir dir="${maven.reporting.outputDirectory}"/>
		<pmd shortFilenames="true" failonerror="false" failOnRuleViolation="false" minimumPriority="5" failuresPropertyName="pmderrors" rulesetfiles="${maven.build.pmddir}/ruleset_j2ee.xml,${maven.build.pmddir}/ruleset_basics.xml">				<sourceLanguage name="java" version="1.6"/>
				<formatter type="xml" toFile="${maven.reporting.outputDirectory}/pmd_report.xml">
						<param name="linkPrefix" value="http://pmd.sourceforge.net/xref/"/>
				</formatter>
				<fileset dir="${maven.build.srcDir}"/>
		</pmd>
		<xslt in="${maven.reporting.outputDirectory}/pmd_report.xml" style="${maven.build.pmddir}/pmd.xsl" out="${maven.reporting.outputDirectory}/pmd_report_${ant.project.name}.html" />
		<delete file="${maven.reporting.outputDirectory}/pmd_report.xml"/>
		  	<if>
		  					 <equals arg1="${pmderrors}" arg2="$${pmderrors}"/>
		  					 <then>
		  					 	<property name="pmdreporterrcnt" value="0"/>
		  					</then> 
		  					 	<else>
		  					 		<property name="pmdreporterrcnt" value="${pmderrors}"/>
		  					    </else>
		  	</if>

		<echo message="Number of PMD Errors: ${pmdreporterrcnt}"/>
	</target>

  <!-- ====================================================================== -->
  <!-- Package target                                                         -->
  <!-- ====================================================================== -->
  <target name="package" depends="compile,test" description="Package the application as a JAR/WAR whatever">
	<pathconvert property="manifest.classpath" pathsep=" ">
	  <path refid="libpath"/>
	  <mapper>
	    <chainedmapper>
	       <flattenmapper/>
	       <globmapper from="*.jar" to="${project.3rdpartylibdir}/*.jar"/>
	    </chainedmapper>
	  </mapper>
	</pathconvert>
    <jar jarfile="${maven.build.dir}/${maven.build.finalName}.jar" 
         compress="true"   index="false" 
         basedir="${maven.build.outputDir}"  excludes="**/package.html">
    	 <manifest>
    	  	<attribute name="Built-By" value="${user.name}"/>
    	 	<attribute name="Created-By" value="Build Tool V1"/>
    	    <attribute name="Implementation-Title" value="${actualbuildname}.jar"/>
    	    <attribute name="Implementation-Version" value="${maven.build.version}-${MYTIME}"/> 
    	    <attribute name="Implementation-Vendor" value="SeshagiriSriram"/>
    	 	<attribute name="Class-Path" value="${manifest.classpath}"/>
    	 </manifest>
   </jar>
  </target>

  <!-- ====================================================================== -->
  <!-- A dummy target for the package named after the type it creates         -->
  <!-- ====================================================================== -->
  <target name="jar" depends="package" description="Builds the jar for the application"/>

  <!-- ====================================================================== -->
  <!-- Zips files into a zip for deployment                                   -->
  <!-- ====================================================================== -->
	  <target name="zip" depends="package" description="Zips all Resources">
	  	<if>
	  					 <equals arg1="${zipoutput}" arg2="$${zipoutput}"/>
	  					 <then>
	  					 	<property name="zipoutputdir" value="${maven.build.dir}"/>
	  					</then> 
	  					 	<else>
	  					 		<property name="zipoutputdir" value="${zipoutput}"/>
	  					    </else>
	  	</if>
	  	<echo message="Copying files from ${maven.build.resourceDir} to ${maven.build.dir}/tmp"/>
		<mkdir dir="${maven.build.dir}/tmp"/>
	  	<mkdir dir="${zipoutputdir}"/>
	  	<echo message="Resource Directory: ${maven.build.resourceDir}" /> 
	  	<copy todir="${maven.build.dir}/tmp" overwrite="true">
	  		<fileset dir="${maven.build.resourceDir}"/>
	  		<file name="${maven.build.dir}/${maven.build.finalName}.jar"/>
	  	</copy>
	  	<zip destfile="${zipoutputdir}/${maven.build.finalName}.zip">
	  		<zipfileset dir="${maven.build.dir}/tmp" includes="*.properties,*.xml,*.txt, ${maven.build.finalName}.jar"/>
	  		<zipfileset dir="./lib" prefix="lib"/> 
	  	</zip>
		<delete dir="${maven.build.dir}/tmp"/>
	  	<delete dir="${project.3rdpartylibdir}"/>
	  	<mkdir dir="${project.3rdpartylibdir}"/>
	  	<delete file="${maven.build.dir}/../${maven.build.finalName}.zip"/> 
	  </target>

  <!-- ====================================================================== -->
  <!-- Download dependencies target                                           -->
  <!-- ====================================================================== -->
  <target name="test-offline" description="Checks if Maven has been configured to run in offline mode">
    <condition property="maven.mode.offline">
      <equals arg1="${maven.settings.offline}" arg2="true"/>
    </condition>
  </target>

   <!-- ====================================================================== -->
   <!-- Installs components to Artifactory                                     -->
   <!-- ====================================================================== -->
	<target name="install" depends="zip" description="Installs the JAR to artifactory"> 
			<echo message="Maven is found in: ${env.MAVEN_HOME}"/>
			<artifact:deploy file="${maven.build.dir}/${maven.build.finalName}.jar">
			      <pom file="pom.xml"/>
			    <remoteRepository url="${env.BUILD_URL}"/>
			 </artifact:deploy>
	   </target>

   <!-- ====================================================================== -->
   <!-- Performs SonarQube Analysis on code                                    -->
   <!-- ====================================================================== -->
	<target name="sonar" description="Performs SonarQube Analysis on code">
	<taskdef uri="antlib:org.sonar.ant" resource="org/sonar/ant/antlib.xml"  classpathref="maven-ant-tasks.classpath" />
	<!-- Execute the SonarQube analysis -->
	<sonar:sonar />
	</target> 

  <!-- ====================================================================== -->
  <!-- Copy files required for instrumentation                                -->
  <!-- ====================================================================== -->
	
	<target name="prepare" depends="clean, maven_dep_copy">
	    <mkdir dir="${maven.reporting.outputDirectory}" />
	    <!-- cobertura directories -->
	    <mkdir dir="${cobertura.dir}" />
	    <mkdir dir="${cob.instrumented.dir}" />
	    <mkdir dir="${cob.reports.xml.dir}" />
	    <mkdir dir="${cob.reports.html.dir}" />
	    <mkdir dir="${cob.coverage.xml.dir}" />
	    <mkdir dir="${cob.coverage.html.dir}" />
		<!-- WE DO NOT HAVE LIBS IN OUR APPLICTION - SO WE DEFINE THE TASK AFTER GETTING THE FILE --> 
		<path id="cobertura.classpath">
			<fileset dir="${lib.cobertura.dir}">
			        <include name="cobertura.jar" />
			        <include name="lib/**/*.jar" />
			    </fileset>
		    <fileset dir="${project.3rdpartylibdir}"/>
		  </path>
		  <taskdef resource="tasks.properties" classpathref="cobertura.classpath"/>
	  </target>
	
  <!-- ====================================================================== -->
  <!-- Do Actual Instrumentation                                              -->
  <!-- ====================================================================== -->

	<target name="instrument" depends="prepare,compile-tests">
		<echo>Class Path: ${toString:cobertura.classpath}</echo>
	    <cobertura-instrument todir="${cob.instrumented.dir}">
	      <fileset dir="${maven.build.outputDir}">
	        <include name="**/*.class"/>
	      </fileset>
	    </cobertura-instrument>
	  </target>
	
  <!-- ====================================================================== -->
  <!-- Call Instrumentation                                                   -->
  <!-- ====================================================================== -->

	  <target name="cover-test" depends="instrument">
	  	<echo message="Instrumented dir:${cob.instrumented.dir}"/>
	  	<junit printSummary="yes" haltonerror="no" haltonfailure="no" fork="yes" dir=".">
	  	      <sysproperty key="basedir" value="."/>
	  	    <sysproperty key="net.sourceforge.cobertura.datafile"
	  	        file="${cob.ser.file}" />
	  	    <!--
	  	        Note the classpath order: instrumented classes are before the
	  	        original (uninstrumented) classes.  This is important.
	  	    -->
	  	    <classpath location="${cob.instrumented.dir}" />
	  	    <classpath location="${maven.build.outputDir}" />
	  		<classpath refid="cobertura.classpath" />
		  	  <classpath>
	  	     	<fileset dir="${project.3rdpartylibdir}"/>
	  	        <pathelement location="${maven.build.testOutputDir}"/>
	  	      </classpath>
	  	   
	        <batchtest skipNonTests="false" todir="${maven.test.reports}">
	          <fileset dir="${maven.build.testDir}">
	            <include name="**/Test*.java"/>
	            <include name="**/*Test.java"/>
	            <include name="**/*TestCase.java"/>
	            <exclude name="**/*Abstract*Test.java"/>
	          </fileset>
	        </batchtest>

		</junit>
	  </target>
	
  <!-- ====================================================================== -->
  <!-- Report on this....                                                     -->
  <!-- ====================================================================== -->

	  <!-- run this target to generate the coverage reports -->
	  <target name="coverage-report" depends="cover-test">
	    <cobertura-report srcdir="${src.dir}" destdir="${cobertura.dir}"/>
	  </target>


</project>
