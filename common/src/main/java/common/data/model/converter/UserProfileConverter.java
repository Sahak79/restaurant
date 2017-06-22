package common.data.model.converter;


import common.data.model.lcp.UserProfile;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserProfileConverter implements AttributeConverter<UserProfile, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserProfile profile) {
        return profile.getValue();
    }

    @Override
    public UserProfile convertToEntityAttribute(Integer value) {
        return UserProfile.valueOf(value);
    }
}

