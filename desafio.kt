// [codigo no Kotlin Playground](https://pl.kotl.in/3_CxO5z_-)


enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val id: Int)

data class ConteudoEducacional(val nome: String, var duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val  inscritos = mutableListOf<Usuario>()
    
    fun alunos() : String {
        val count = inscritos.count()
		var result = ""
        if(count == 1){ 
            result = "${inscritos.first().nome}"
        } else {
            for (user in inscritos) { result = "$result${user.nome}, "}
        }
        return result
    }

    
    fun matricular(vararg usuarios: Usuario) { 
       for (usuario in usuarios) inscritos.add(usuario)
    }
    
    fun duracao() : String{
       var total = 0
        for (conteudo in this.conteudos) { total = total + conteudo.duracao }
        return "$total horas"
    }
}

fun main() {
val usuario1: Usuario = Usuario("João", 1)
val usuario2: Usuario = Usuario("Lucas", 2)
val usuario3: Usuario = Usuario("Pedro", 3)
val usuario4: Usuario = Usuario("josé", 4)
val usuario5: Usuario = Usuario("Maria", 5)
val usuario6: Usuario = Usuario("Bruna", 6)

val conteudo1 : ConteudoEducacional = ConteudoEducacional("Kotlin", 20)
val conteudo2 : ConteudoEducacional = ConteudoEducacional("Java", 30)
val conteudo3 : ConteudoEducacional = ConteudoEducacional("Flutter", 15)

val conteudo4 : ConteudoEducacional = ConteudoEducacional("Excel", 15)
val conteudo5 : ConteudoEducacional = ConteudoEducacional("Word", 15)



val formacao1 : Formacao = Formacao(nome = "Formacao Android", nivel = Nivel.INTERMEDIARIO, conteudos = listOf(conteudo1, conteudo2, conteudo3))
formacao1.matricular(usuario1, usuario2, usuario3)

val formacao2 : Formacao = Formacao(nome = "Formacao pacote office", nivel = Nivel.BASICO, conteudos = listOf(conteudo4, conteudo5))
formacao2.matricular(usuario5)

val formacao3 : Formacao = Formacao(nome = "Formacao completa", nivel = Nivel.DIFICIL, conteudos = listOf(conteudo1, conteudo2, conteudo3, conteudo4, conteudo5))
formacao3.matricular(usuario1, usuario2, usuario3, usuario4, usuario5, usuario6)

print("Formação 1: ")
println(formacao1.alunos())
println(formacao1.duracao())

print("Formação 2: ")
println(formacao2.alunos())
println(formacao2.duracao())

print("Formação 3: ")
println(formacao3.alunos())
println(formacao3.duracao())
}