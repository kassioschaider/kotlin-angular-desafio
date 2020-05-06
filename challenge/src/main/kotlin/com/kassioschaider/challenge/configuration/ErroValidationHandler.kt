package com.kassioschaider.challenge.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*
import java.util.function.Consumer

@RestControllerAdvice
class ErroValidationHandler(private @field:Autowired val messageSource: MessageSource? = null) {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handle(exception: MethodArgumentNotValidException): List<ErrorDTO> {
        val dtoList: MutableList<ErrorDTO> = ArrayList<ErrorDTO>()
        val fieldErrors = exception.bindingResult.fieldErrors
        fieldErrors.forEach(Consumer { e: FieldError ->
            val mensagem = messageSource!!.getMessage(e, LocaleContextHolder.getLocale())
            val erro = ErrorDTO(e.field, mensagem)
            dtoList.add(erro)
        })
        return dtoList
    }

    private fun fieldToTitle(field: String): String {
        return when (field) {
            "nome" -> "Nome"
            "dataNascimento" -> "Data de Nascimento"
            "cpf" -> "CPF"
            "idEmpresa" -> "Empresa"
            "endereco" -> "Endereço"
            "cnpj" -> "CNPJ"
            else -> field
        }
    }
}