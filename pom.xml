<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.edurekademo.tutorial</groupId>
    <artifactId>addressbook</artifactId>
    <packaging>war</packaging>
    <version>2.0</version>
    <name>Vaadin Addressbook example</name>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <failOnMissingWebXml>false</failOnMissingWebXml>
        <vaadin.version>8.0.0.alpha2</vaadin.version>
        <vaadin.plugin.version>${vaadin.version}</vaadin.plugin.version>
    </properties>

    <repositories>
        <repository>
            <id>vaadin-prereleases</id>
            <name>Vaadin Pre-releases</name>
            <url>https://maven.vaadin.com/vaadin-prereleases</url>
        </repository>
        <!-- Essential Vaadin artifacts are in maven central, but maven.vaadin.com 
            contains a huge set of additional libraries. See vaadin.com/directory -->
       <repository>
            <id>vaadin-addons</id>
            <url>http://maven.vaadin.com/vaadin-addons</url>
        </repository>

        <repository>
            <id>vaadin-snapshots</id>
            <url>http://oss.sonatype.org/content/repositories/vaadin-snapshots/</url>
            <releases>
                <enabled>false</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>

    <pluginRepositories>
        <pluginRepository>
            <id>vaadin-snapshots</id>
            <url>http://oss.sonatype.org/content/repositories/vaadin-snapshots/</url>
            <releases>
                <enabled>false</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </pluginRepository>
    </pluginRepositories>


    <dependencies>
        <dependency>
            <groupId>com.vaadin</groupId>
            <artifactId>vaadin-compatibility-server</artifactId>
            <version>${vaadin.version}</version>
        </dependency>
        <dependency>
            <groupId>com.vaadin</groupId>
            <artifactId>vaadin-compatibility-shared</artifactId>
            <version>${vaadin.version}</version>
        </dependency>
         <dependency>
            <groupId>com.vaadin</groupId>
            <artifactId>vaadin-compatibility-client-compiled</artifactId>
            <version>${vaadin.version}</version>
        </dependency>
        <dependency>
            <groupId>com.vaadin</groupId>
            <artifactId>vaadin-themes</artifactId>
            <version>${vaadin.version}</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.0.1</version>
            <scope>compile</scope>
        </dependency>
        <!-- The huge set of awesome Java libraries are available as such 
            for Vaadin developers, you should take the advantage of those. In this app 
            we just use the commons-beanutils to help implementing the fake backend. -->
        <dependency>
            <groupId>commons-beanutils</groupId>
            <artifactId>commons-beanutils</artifactId>
            <version>1.9.2</version>
            <type>jar</type>
        </dependency>
		
				<!-- LOGGING -->
		<dependency>
	<groupId>log4j</groupId>
	<artifactId>log4j</artifactId>
	<version>1.2.9</version>
</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
			<version>1.7.7</version>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-simple</artifactId>
			<version>1.7.7</version>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-log4j12</artifactId>
			<version>1.7.7</version>
		</dependency>

				<!-- TESTING -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.7</version>
			<scope>test</scope>
		</dependency>


		<!-- COMMONS -->
		<dependency>
			<groupId>commons-httpclient</groupId>
			<artifactId>commons-httpclient</artifactId>
			<version>3.1</version>
		</dependency>

		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
			<version>3.1</version>
		</dependency>

		<!-- JSON -->
		<dependency>
			<groupId>org.json</groupId>
			<artifactId>json</artifactId>
			<version>20140107</version>
		</dependency>
		<dependency>
			<groupId>org.codehaus.jackson</groupId>
			<artifactId>jackson-jaxrs</artifactId>
			<version>1.9.4</version>
		</dependency>

		<!-- XML -->
		<dependency>
			<groupId>com.sun.xml.security</groupId>
			<artifactId>xml-security-impl</artifactId>
			<version>1.0</version>
		</dependency>


		</dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.2</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.eclipse.jetty</groupId>
                <artifactId>jetty-maven-plugin</artifactId>
                <version>9.2.3.v20140905</version>
            </plugin>
			
						<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>2.19.1</version>
				<configuration>
					<parallel>methods</parallel>
					<threadCount>10</threadCount>
					<includes>
						<include>**/Test*.java</include>
						<include>**/Test.java</include>
						<include>**/TestCase.java</include>
					</includes>
					<excludes>
						<exclude>**/*Abstract*Test.java</exclude>
					</excludes>
				</configuration>
			</plugin>

        </plugins>
		<finalName>addressbook</finalName>
    </build>
	
	  
    <reporting>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-report-plugin</artifactId>
        <version>2.19.1</version>
      </plugin>
    </plugins>
  </reporting>
  
      <profiles>
        <profile>
            <id>development</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>

        </profile>
        <profile>
            <id>metrics</id>
            <build>
                <plugins>
                    <!-- CHECKSTYLE -->
                    <!--<plugin>-->
                        <!--<artifactId>maven-checkstyle-plugin</artifactId>-->
                        <!--<version>2.9.1</version>-->
                        <!--<dependencies>-->
                            <!--<dependency>-->
                                <!--<groupId>com.wakaleo.gameoflife</groupId>-->
                                <!--<artifactId>gameoflife-build</artifactId>-->
                                <!--<version>${project.version}</version>-->
                            <!--</dependency>-->
                        <!--</dependencies>-->
                        <!--<configuration>-->
                            <!--<configLocation>custom-checkstyle.xml</configLocation>-->
                        <!--</configuration>-->
                    <!--</plugin>-->

                    <!-- PMD -->
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-pmd-plugin</artifactId>
                        <version>3.2</version>
                        <configuration>
                            <targetJdk>1.8</targetJdk>
                            <aggregate>true</aggregate>
                            <format>xml</format>
                            <!-- CPD options -->
                            <minimumTokens>20</minimumTokens>
                            <!--<ignoreIdentifiers>true</ignoreIdentifiers>-->
                            <failOnViolation>true</failOnViolation>
                            <failurePriority>2</failurePriority>
                        </configuration>
                    </plugin>

                    <!-- FINDBUGS -->
                    <plugin>
                        <artifactId>findbugs-maven-plugin</artifactId>
                        <version>2.4.0</version>
                        <configuration>
                            <effort>Max</effort>
                            <xmlOutput>true</xmlOutput>
                        </configuration>
                    </plugin>
                </plugins>
            </build>
        </profile>
        <profile>
            <id>maven3</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-enforcer-plugin</artifactId>
                        <version>1.0</version>
                        <executions>
                            <execution>
                                <id>enforce-versions</id>
                                <goals>
                                    <goal>enforce</goal>
                                </goals>
                                <configuration>
                                    <rules>
                                        <requireMavenVersion>
                                            <version>[3.0,)</version>
                                        </requireMavenVersion>
                                    </rules>
                                </configuration>
                            </execution>
                        </executions>
                    </plugin>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-site-plugin</artifactId>
                        <version>3.3</version>
                        <configuration>
                            <reportPlugins>
                                <plugin>
                                    <artifactId>maven-project-info-reports-plugin</artifactId>
                                    <version>2.7</version>
                                </plugin>
                                <plugin>
                                    <groupId>org.jacoco</groupId>
                                    <artifactId>jacoco-maven-plugin</artifactId>
                                    <version>0.7.2.201409121644</version>
                                </plugin>
                                <plugin>
                                    <groupId>org.apache.maven.plugins</groupId>
                                    <artifactId>maven-checkstyle-plugin</artifactId>
                                    <version>3.0.1</version>
                                    <!--<configuration>-->
                                    <!--<configLocation>gol-checkstyle.xml</configLocation>-->
                                    <!--</configuration>-->
                                </plugin>
                                <plugin>
                                    <groupId>org.apache.maven.plugins</groupId>
                                    <artifactId>maven-pmd-plugin</artifactId>
                                    <version>3.2</version>
                                    <configuration>
                                        <targetJdk>1.8</targetJdk>
                                        <aggregate>true</aggregate>
                                        <format>xml</format>
                                        <rulesets>
                                            <ruleset>/pmd-rules.xml</ruleset>
                                        </rulesets>
                                        <!-- CPD options -->
                                        <minimumTokens>20</minimumTokens>
                                        <ignoreIdentifiers>true</ignoreIdentifiers>
                                    </configuration>
                                </plugin>
                                <plugin>
                                    <groupId>org.codehaus.mojo</groupId>
                                    <artifactId>findbugs-maven-plugin</artifactId>
                                    <version>2.4.0</version>
                                    <configuration>
                                        <effort>Max</effort>
                                        <xmlOutput>true</xmlOutput>
                                    </configuration>
                                </plugin>
                                <plugin>
                                    <artifactId>maven-javadoc-plugin</artifactId>
                                    <version>2.9.1</version>
                                    <configuration>
                                        <source>1.8</source>
                                        <doclet>
                                            gr.spinellis.umlgraph.doclet.UmlGraphDoc
                                        </doclet>
                                        <docletArtifact>
                                            <groupId>gr.spinellis</groupId>
                                            <artifactId>UmlGraph</artifactId>
                                            <version>4.6</version>
                                        </docletArtifact>
                                        <additionalparam>
                                            -inferrel -inferdep -hide java.* -collpackages
                                            java.util.* -attributes -operations
                                            -enumerations -enumconstants
                                        </additionalparam>
                                    </configuration>
                                </plugin>
                                <plugin>
                                    <groupId>org.apache.maven.plugins</groupId>
                                    <artifactId>maven-jxr-plugin</artifactId>
                                    <version>2.4</version>
                                </plugin>
                            </reportPlugins>
                        </configuration>
                        <dependencies>
                            <dependency>
                                <groupId>com.edurekademo.tutorial</groupId>
                                <artifactId>addressbook</artifactId>
                                <version>${project.version}</version>
                            </dependency>
                        </dependencies>
                    </plugin>
                </plugins>
            </build>
        </profile>
        <profile>
            <id>maven2</id>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-enforcer-plugin</artifactId>
                        <version>1.0</version>
                        <executions>
                            <execution>
                                <id>enforce-versions</id>
                                <goals>
                                    <goal>enforce</goal>
                                </goals>
                                <configuration>
                                    <rules>
                                        <requireMavenVersion>
                                            <version>[2.0.9, 2.2.1]</version>
                                        </requireMavenVersion>
                                    </rules>
                                </configuration>
                            </execution>
                        </executions>
                    </plugin>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-site-plugin</artifactId>
                        <version>2.1.1</version>
                        <dependencies>
                            <dependency>
                                <groupId>com.edurekademo.tutorial</groupId>
                                <artifactId>addressbook</artifactId>
                                <version>${project.version}</version>
                            </dependency>
                        </dependencies>
                    </plugin>
                </plugins>
            </build>
            <reporting>
                <plugins>
                    <plugin>
                        <groupId>org.codehaus.mojo</groupId>
                        <artifactId>cobertura-maven-plugin</artifactId>
                        <version>${cobertura.version}</version>
                        <configuration>
                            <formats>
                                <format>html</format>
                                <format>xml</format>
                            </formats>
                        </configuration>
                    </plugin>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-pmd-plugin</artifactId>
                        <version>2.5</version>
                        <configuration>
                            <targetJdk>1.8</targetJdk>
                            <aggregate>true</aggregate>
                            <format>xml</format>
                            <rulesets>
                                <ruleset>/pmd-rules.xml</ruleset>
                            </rulesets>
                            <!-- CPD options -->
                            <minimumTokens>20</minimumTokens>
                            <ignoreIdentifiers>true</ignoreIdentifiers>

                        </configuration>
                    </plugin>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-checkstyle-plugin</artifactId>
                        <version>2.9.1</version>
                        <configuration>
                            <configLocation>addressbook-build/checkstyle.xml</configLocation>
                        </configuration>
                    </plugin>
                    <plugin>
                        <groupId>org.codehaus.mojo</groupId>
                        <artifactId>findbugs-maven-plugin</artifactId>
                        <version>2.4.0</version>
                        <configuration>
                            <effort>Max</effort>
                            <xmlOutput>true</xmlOutput>
                        </configuration>
                    </plugin>
                    <plugin>
                        <artifactId>maven-javadoc-plugin</artifactId>
                        <version>2.7</version>
                        <configuration>
                            <source>1.8</source>
                            <doclet>
                                gr.spinellis.umlgraph.doclet.UmlGraphDoc
                            </doclet>
                            <docletArtifact>
                                <groupId>gr.spinellis</groupId>
                                <artifactId>UmlGraph</artifactId>
                                <version>4.6</version>
                            </docletArtifact>
                            <additionalparam>
                                -inferrel -inferdep -hide java.* -collpackages
                                java.util.* -attributes -operations
                                -enumerations -enumconstants
                            </additionalparam>
                        </configuration>
                    </plugin>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-jxr-plugin</artifactId>
                        <version>2.1</version>
                    </plugin>
                </plugins>
            </reporting>
        </profile>
    </profiles>

</project>
