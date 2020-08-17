package application.extension;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DecimalFormat;




public class CustomPriceSerializer extends JsonSerializer<Double> {

    @Override
    public void serialize(Double value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        DecimalFormat format = new DecimalFormat("##,###,###");
        try {
            if (value == null) {
                gen.writeNull();
            }
            else {
                gen.writeString(format.format(value));
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
