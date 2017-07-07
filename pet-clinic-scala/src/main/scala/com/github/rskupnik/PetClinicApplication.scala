package com.github.rskupnik

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.{ComponentScan, Configuration}

@Configuration
@EnableAutoConfiguration
@ComponentScan
class PetClinicConfig

object PetClinicApplication extends App {
  SpringApplication.run(classOf[PetClinicConfig])
}
