package model;

public class Usuario {
       
    // conferir variaveis com o banco dps
    
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String senha;
    
    public Usuario(String nome, String rg, String cpf, String email, String senha){
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getRg(){
        return rg;
    }
        
    public String getCpf(){
        return cpf;
    }
            
    public String getEmail(){
        return email;
    }
    
    public String getSenha(){
        return senha;
    }
}
