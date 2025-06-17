package com.alura.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {
   private ObjectMapper objectMapper = new ObjectMapper();

   // esto lo coloco la clase ConvuerteDatos, revisar
//   @Override
//   public <T> T convertData(String json, Class<T> clase) {
//      return null;
//   }

   // mirar JsonProcessingException va en el catch
   @Override
   public <T> T obtenerDatos(String json, Class<T> clase) {
      try {
         return objectMapper.readValue(json,clase);
      } catch (JsonMappingException e) {
         throw new RuntimeException(e);
      } catch (JsonProcessingException e) {
         throw new RuntimeException(e);
      }
   }
}
