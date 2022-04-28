package com.xisen.serviceconsumer9001;

import com.xisen.userserviceapi.UserServiceAPI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@FeignClient(value = "service-provider-8001")
public interface UserService extends UserServiceAPI {
}
