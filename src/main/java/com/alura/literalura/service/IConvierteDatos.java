package com.alura.literalura.service;

public interface IConvierteDatos {
   <T> T convertData(String json, Class<T> clase);

   // mirar JsonProcessingException va en el catch
   //@Override
   <T> T obtenerDatos(String json, Class<T> clase);
}
