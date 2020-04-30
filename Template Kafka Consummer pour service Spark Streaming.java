  import org.apache.spark.streaming.kafka010.KafkaUtils
  import org.apache.kafka.clients.consumer.ConsumerRecord
  import org.apache.kafka.common.serialization.StringDeserializer
  import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
  import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
  import org.apache.kafka.common.protocol.SecurityProtocol
  /**
    * Cette fonction retourne les param�tres n�cessaires pour �tablir une connexion avec Kafka
    * @param kafkaBootstrapServers :les serveurs de Kafka
    * @param kafkaConsumerGroupId : le Coonsumer Group Id de Kafka
    * @param kafkaConsumerAutoOffsetReset : le mode de lecture des donn�es de la file Kafka ("latest" par d�faut)
    * @return : les param�tres Kafka
    */
	
   /* pour utiliser ce template, reférez-vous à la leçon 6 "methodologie de développement d'un service streaming" du module 5 */	
  private def getKafkaConsumerParams(kafkaBootstrapServers : String, kafkaConsumerGroupId : String, kafkaConsumerAutoOffsetReset : String, zookeeperServers : String) : Map[String, Object] = {

    val kafkaConsumerParams = Map[String, Object](
      "zookeeper.hosts" -> zookeeperServers,
      "zookeeper.port" -> "2181",
      "zookeeper.broker.path" -> "/kafka",
      "bootstrap.servers" -> kafkaBootstrapServers,
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> kafkaConsumerGroupId,
      "auto.offset.reset" -> kafkaConsumerAutoOffsetReset,
      "enable.auto.commit" -> (false: java.lang.Boolean),
      "security.protocol" -> SecurityProtocol.PLAINTEXT ,
      "sasl.kerberos.service.name" -> "kafka"
    )
    logger.info(s"kafkaConsumerParams: $kafkaConsumerParams")
    kafkaConsumerParams
  }

  /**
    * d�finition du consumer (ou consommateur) client qui va s'abonner au topir Kafka concern� par le projet et qui va recevoir les �v�nements
    * @param kafkaConsumerTopic : le topic Kafka � consommer
    * @param kafkaBootstrapServers : serveurs Kafka
    * @param kafkaConsumerGroupId : Kafka Consumer Group ID
    * @param kafkaConsumerAutoOffsetReset : le mode de lecture des donn�es de la file Kafka ("latest" par d�faut)
    * @param sparkStreamingContext : le contexte sparkStreaming
    * @return : le singleton du consommateur Kafka
    */
	
  def getKafkaConsumer(kafkaConsumerTopic : Array[String], kafkaBootstrapServers : String, kafkaConsumerGroupId : String, kafkaConsumerAutoOffsetReset : String, sparkStreamingContext: StreamingContext, zookeeperServers : String ) : InputDStream[ConsumerRecord[String, String]] = {

    logger.info("Getting kafkaConsumer Object...")


      case ex : Exception => logger.error(s"An Exception occured when getting the kafka consumer new context:\n${ex.printStackTrace()}")
    }

    kafkaConsumer
  }