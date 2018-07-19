//package com.pl.dto;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import org.springframework.hateoas.ResourceSupport;
//
//import java.util.Arrays;
//import java.util.Map;
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class QuizowanieDto extends ResourceSupport{
//
//        private int idQuiz;
//        private String nameTravel;
//        private String continent;
//        private String country;
//        private String town;
//        private String speciesUrl;
//        private String speciesName;
//
//        @JsonProperty("abilities")
//        private AbilitiesDto[] abilities;
//
//
//        @JsonProperty("stats")
//        private StatsDto[] statsDto;
//
//        public PokemonDto() {
//        }
//
//        public String getContinent() {
//            return continent;
//        }
//
//        public void setContinent(String continent) {
//            this.continent = continent;
//        }
//
//        public String getCountry() {
//            return country;
//        }
//
//        public void setCountry(String country) {
//            this.country = country;
//        }
//
//        public String getTown() {
//            return town;
//        }
//
//        public void setTown(String town) {
//            this.town = town;
//        }
//
//        public int getIdPokemon() {
//            return idTravel;
//        }
//
//        public void setIdPokemon(int idTravel) {
//            this.idTravel = idTravel;
//        }
//
//        public String getName() {
//            return nameTravel;
//        }
//
//        public void setName(String nameTravel) {
//            this.nameTravel = nameTravel;
//        }
//
//        public String getWeight() {
//            return continent;
//        }
//
//        public void setWeight(String continent) {
//            this.continent = continent;
//        }
//
//        public PokemonDto(int idTravel, String nameTravel, String continent) {
//            this.idTravel = idTravel;
//            this.nameTravel = nameTravel;
//            this.continent = continent;
//
//        }
//
//        @SuppressWarnings("unchecked")
//        @JsonProperty("species")
//        private void unpackNested(Map<String, Object> spec) {
//            this.speciesName = (String) spec.get("nameTravel");
//            this.speciesUrl = (String) spec.get("url");
//        }
//
//        public String getSpeciesName() {
//            return speciesName;
//        }
//
//        public void setSpeciesName(String speciesName) {
//            this.speciesName = speciesName;
//        }
//
//        public String getSpeciesUrl() {
//            return speciesUrl;
//        }
//
//        public void setSpeciesUrl(String speciesUrl) {
//            this.speciesUrl = speciesUrl;
//        }
//
//        @Override
//        public String toString() {
//            return "PokemonDto{" +
//                    "nameTravel='" + nameTravel + '\'' +
//                    ", continent='" + continent + '\'' +
//                    ", country='" + country + '\'' +
//                    ", town='" + town + '\'' +
//                    ", speciesUrl='" + speciesUrl + '\'' +
//                    ", speciesName='" + speciesName + '\'' +
//                    ", abilities=" + Arrays.toString(abilities) +
//                    '}';
//        }
//
//    }
//}
