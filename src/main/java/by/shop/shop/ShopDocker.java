package by.shop.shop;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;

import java.util.List;

public class ShopDocker {
    public static void main(String[] args) {
        DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();

        DockerClient client = DockerClientBuilder.getInstance(config).build();

        List<Container> containers = client.listContainersCmd().exec();
        containers.forEach(System.out::println);


    }
}
