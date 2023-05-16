# Spring Security 6 avec Thymeleaf
Voici ma propre solution de l'activité pratique N°4

- L'objectif de cette activité pratique est de créer une application Web JEE basée sur Spring MVC, Thylemeaf et Spring Data JPA qui permet de gérer les patients en faisant usage également au framework Spring Security

1 - Continuant sur l'activité N°3 : 
![screenMVC1](https://user-images.githubusercontent.com/91842692/232930157-5f6f030e-7dd7-40f9-935b-47fe10a08df6.PNG)

2 - Personnalisation de la configuration du sring Security : 
       I - Création d'une classe de configuration de sécurité : 
       ![screenMVC2](https://user-images.githubusercontent.com/91842692/232934688-5a72233d-415f-415a-b52c-3b999ac2a1c0.PNG)
       II - Création d'un controlleur de sécurité : 
       ![screenMVC3](https://user-images.githubusercontent.com/91842692/232934973-e0dc46a5-b297-4df6-91e8-cef3be4da1f9.PNG)
       III - Création de la vue JSP login : 
       ![screenMVC4](https://user-images.githubusercontent.com/91842692/232935384-1a17b610-d054-4c55-ba09-03059321527f.PNG)
       IV - Création de la vue JSP NotAuthorized : 
       ![screenMVC5](https://user-images.githubusercontent.com/91842692/232935475-69c4ce56-45b8-4bbb-8cda-861bb144821e.PNG)
       
3 - Interface personnalisé du formulaire Login : 
![screenMVC6](https://user-images.githubusercontent.com/91842692/232935671-a8ea5490-0fa0-4a95-bcf3-082b9b67d054.PNG)

4 - Interface utilisateur normal : 
![screenMVC7](https://user-images.githubusercontent.com/91842692/232935911-25d60549-dab7-4d23-a2c3-563ff4833223.PNG)

5 - Interface non authorisé : 
![screenMVC8](https://user-images.githubusercontent.com/91842692/232936239-b5b1be36-106c-4da3-a1b5-95b340af41af.PNG)

6 - Ajout d'un boutton afin de se déconnecter directement sans passer pas la page Logout : 
![screenMVC9](https://user-images.githubusercontent.com/91842692/232936631-0ac909da-f1ad-49d9-a52a-dee24e285290.PNG)

![screenMVC10](https://user-images.githubusercontent.com/91842692/232937052-2807907a-eef1-4b78-826b-99373abdfd67.PNG)

7 - Verfier si l'utilisateur authentifié dispose des droites d'accès : 
![screenMVC11](https://user-images.githubusercontent.com/91842692/232937462-276afd3b-d125-4ce9-af88-f46e2f5c44da.PNG)


