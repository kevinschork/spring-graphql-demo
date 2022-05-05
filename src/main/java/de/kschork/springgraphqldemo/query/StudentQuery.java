package de.kschork.springgraphqldemo.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class StudentQuery implements GraphQLQueryResolver {

    public String firstQuery () {
        return "First Query";
    }

}
