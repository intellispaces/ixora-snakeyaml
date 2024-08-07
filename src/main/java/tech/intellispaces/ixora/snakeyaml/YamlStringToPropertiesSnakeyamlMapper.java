package tech.intellispaces.ixora.snakeyaml;

import intellispaces.ixora.structures.exception.InvalidPropertyException;
import intellispaces.ixora.structures.properties.PropertiesHandle;
import intellispaces.ixora.structures.properties.YamlStringToPropertiesMapper;

import org.yaml.snakeyaml.Yaml;

import tech.intellispaces.core.annotation.Guide;
import tech.intellispaces.core.annotation.Mapper;
import tech.intellispaces.ixora.structures.properties.MapBasedProperties;

@Guide
public class YamlStringToPropertiesSnakeyamlMapper implements YamlStringToPropertiesMapper {

  @Mapper
  @Override
  public PropertiesHandle yamlStringToProperties(String string) throws InvalidPropertyException {
    try {
      var yaml = new Yaml();
      return new MapBasedProperties(yaml.load(string));
    } catch (Exception e) {
      throw InvalidPropertyException.withCauseAndMessage(e, "Failed to load YAML");
    }
  }
}
