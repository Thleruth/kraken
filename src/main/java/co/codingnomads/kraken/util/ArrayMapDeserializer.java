package co.codingnomads.kraken.util;

import co.codingnomads.kraken.model.market.AssetPairName;
import co.codingnomads.kraken.model.market.output.GetTradableAssetPairsOutput;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ryandesmond on 12/4/17.
 */
public class ArrayMapDeserializer extends JsonDeserializer<Map<String, AssetPairName>> {

    @Override
    public Map<String, AssetPairName> deserialize(JsonParser jp, DeserializationContext context)
            throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        //JsonNode node = mapper.readTree(jp);

        if (jp.getCurrentToken().equals(JsonToken.START_OBJECT)) {
            System.out.println(mapper.readTree(jp).toString());

//            HashMap<String, GetTradableAssetPairsOutput> myObjects =
//                    mapper.readTree(jp);

            return mapper.readValue(jp, new TypeReference<GetTradableAssetPairsOutput>() {
            });

        } else {
            //consume this stream
            mapper.readTree(jp);
            return new HashMap<String, AssetPairName>();
        }
    }

//    @Override
//    public Map<String, AssetPairName> deserialize(JsonParser jsonParser, DeserializationContext arg1)
//            throws IOException, JsonProcessingException {
//
//        ObjectCodec oc = jsonParser.getCodec();
//        JsonNode node = oc.readTree(jsonParser);
//
//        if (node.getValueAsText() == "")
//            return null;
//
//        MyObject myObject = new MyObject();
//        myObject.setMyStirng(node.get("myString").getTextValue());
//
//        JsonNode childNode = node.get("childObject");
//        ObjectMapper objectMapper = new ObjectMapper();
//        ChildObject childObject = objectMapper.readValue(childNode,
//                ChildObject.class);
//
//        myObject.setChildObject(childObject);
//        return myObject;
//    }
}