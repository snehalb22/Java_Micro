package com.in28minutes.rest.microservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class FilteringResource {

    @GetMapping("/beans")
    public MappingJacksonValue getBean(){
        SomeBean bean=new SomeBean("value1","value2","value3");
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(bean);

        PropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field2","field1");
        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("SomeBean",filter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue ;
    }

    @GetMapping("/filtering")
    public MappingJacksonValue getallBean(){
        List<SomeBean> bean= Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value1","value2","value3"));


        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(bean);

        PropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field3","field1");
        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("SomeBean",filter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue ;
    }



}
