package com.dius.pact.author

import org.specs2._
import com.dius.pact.model._
import com.dius.pact.model.MakeInteraction._
import Fixtures._


class PactBuilderSpec extends mutable.Specification {
  "Pact Builder" should {
    "construct a pact" in {
      val pact:Pact = MakePact()
        .withProvider(provider.name)
        .withConsumer(consumer.name)
        .withInteractions(
          given(interaction.providerState)
          .uponReceiving( description = interaction.description,
                          path = request.path,
                          method = request.method,
                          headers = request.headers,
                          body = request.body)
          .willRespondWith(status=200, headers = response.headers, body= response.body)
        )

      pact must beEqualTo(Fixtures.pact)
    }
  }
}