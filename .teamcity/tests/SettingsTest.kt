import org.junit.Assert.assertTrue
import org.junit.Test

class StringTests {
    @Test
    fun buildsHaveCleanCheckOut() {
        val project = SpringPetclinic

        project.buildTypes.forEach { bt ->
            assertTrue("BuildType '${bt.id}' doesn't use clean checkout", bt.vcs.cleanCheckout)
        }
    }
}