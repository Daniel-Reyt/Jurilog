<h1>Projet Juri'Log</h1>

<h2>Comment démarrer le projet ?</h2>

<h4>tout d'abord commencez par cloner le projet via votre clef ssh :</h4>

``` 
1. dans votre cli linux ou windows : "cd Desktop/" ou "cd Bureau/"
2. tapez ensuite : "git clone ssh://git@git.uha4point0.fr:22222/UHA40/fil-rouge-2021/4.0.3/fil_rouge_4.0.3_daniel.git"
```

<h4>ensuite positionnez vous sur le dossier cloner et démarrer le docker-compose :</h4>

```
1. dans votre cli : "cd fil_rouge_4.0.3_daniel/"
2. toujours dans votre cli tapez ensuite : "docker-compose -f docker-compose-dev.yml up --build"
```

<h4>pour ensuite vous rendre sur le front taper dans votre navigateur : 
[https://localhost](https://localhost "Angular: Permet de rediriger automatiquement vers le front")</h4>

<h4>pour ensuite vous rendre sur le swagger de l'API taper dans votre navigateur : 
[https://localhost:8888/swagger-ui.html](https://localhost:8888/swagger-ui.html "Swagger: Permet de voir la documentation des routes présentes dans l'api")</h4>

<h4>pour ensuite vous rendre sur un get de l'api taper dans votre navigateur : 
[https://localhost:8888/route](https://localhost:8888/route "Spring: Permet de récupérer les données présentes dans la BDD via des routes d'API")</h4>
