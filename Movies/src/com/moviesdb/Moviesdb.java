package com.moviesdb;

public class Moviesdb {
    public static void main(String[] args){
    	//Creating MoviesDB Database
        Database MoviesDB= new Database();
        MoviesDB.createNewDatabase("MoviesDB.db");
        //Creating table movies in MoviesDB database
        MoviesDB.createNewTable("MoviesDB.db","movies");
        //Inserting (name,actor,actress,year,director)
        MoviesDB.insert("Moonfall","Patrick Wilson","Halle Berry",2022,"Roland Emmerich");
        MoviesDB.insert("Rangasthala","Ram Charan","Samantha Akkineni",2018,"Sukumar Bandreddi");
        MoviesDB.insert("The Fallout","none", "Jenna Ortega", 2021, "Megan Park");
        MoviesDB.insert("Pushpa: The Rise","Allu Arjun","Rashmika Mandanna",2021,"Sukumar Bandreddi");
        MoviesDB.insert("Passengers", "Patrick Wilson", "Anne Hathaway", 2008, "Rodrigo García");
        MoviesDB.insert("U Turn", "Aadhi Pinisetty", "Samantha Akkineni", 2018, "Pawan Kumar");
        //Queries on Database
        //db points to MoviesDB database
        Queries db = new Queries("MoviesDB.db");
        //Select all rows from table movies
        db.selectAll("movies");
        //Select rows with year of release: 2021
        db.year("movies",2021);
        db.name("movies", "Rangasthala");
        db.director("movies", "Sukumar Bandreddi");
        db.actress("movies", "Jenna Ortega");
        db.actor("movies", "Patrick Wilson");
        //run any sql statement on the Database MoviesDB
        db.sqlStatement("SELECT * FROM movies WHERE name = 'Moonfall'");
          
    }
}


