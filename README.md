# desafio_neomind
## Desafio NeoMind

Frontend root: `desafio\src\main\frontend\`

Backend root: `desafio\src\main\java\org\desafio\`

Programming logic root: `desafio\src\main\java\org\logica\`


### Versions:

	- Open JDK: 1.7.0_11-b21
  	- JRE: 1.7
	- Apache Tomcat: 8.5.93
	- Maven: 3.8.8
	- MariaDB: 11.1.2
	- NodeJS: 18.17.1
 	- Yarn: 1.22.19

### Steps to run (backend):

	1. Go to: `desafio\src\main\java\org\desafio\`
	2. Run `mvn clean install` in terminal
	3. Configure TomCat 8.5:
       - Use HTTP port: 8080
       - Use application context: /
       - Use artifact: desafio-war
	4. Configure database (MariaDB 11.1.2):
		- Set URL: `jdbc:mysql://localhost:3306/desafio`
		- Set user: `root`
  		- Set password: `12345678`

### Steps to run (frontend):

	1. Go to: `desafio\src\main\frontend\`
 	2. Run `yarn` in terminal
  	3. Run `yarn build` in terminal
  	4. Run `yarn dev` in terminal

## Open `http://localhost:8081/` in your favorite browser and have fun!
API routes: https://github.com/k1vz/desafio_neomind/blob/main/src/main/java/org/desafio/README.md
