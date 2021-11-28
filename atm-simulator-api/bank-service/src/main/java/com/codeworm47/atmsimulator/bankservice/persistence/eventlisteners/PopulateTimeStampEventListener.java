package com.codeworm47.atmsimulator.bankservice.persistence.eventlisteners;

import com.codeworm47.atmsimulator.bankservice.model.entities.BaseEntity;
import com.codeworm47.atmsimulator.bankservice.model.entities.TimeStampCapable;
import com.codeworm47.atmsimulator.bankservice.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

@Component
public class PopulateTimeStampEventListener extends AbstractMongoEventListener<BaseEntity> {
    @Override
    public void onBeforeSave(BeforeSaveEvent<BaseEntity> event) {
        BaseEntity entity = event.getSource();
        if (TimeStampCapable.class.isAssignableFrom(entity.getClass())){
            if (StringUtils.isEmpty(entity.getId())){
                ((TimeStampCapable) entity).setCreatedDate(DateUtils.nowUtc());
            } else{
                ((TimeStampCapable) entity).setLastModifiedDate(DateUtils.nowUtc());
            }
        }
    }
}
