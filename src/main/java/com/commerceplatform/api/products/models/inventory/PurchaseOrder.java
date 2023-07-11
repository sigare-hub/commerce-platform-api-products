package com.commerceplatform.api.products.models.inventory;


import com.commerceplatform.api.products.models.product.ProductModel;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseOrder {
/**
 * O pedido de compra é um documento que formaliza quais foram os produtos,
 * quantidades, preços e condições de prazo e pagamento acordados com o fornecedor.
 */


// INFORMACOES DO FORNECIMENTO
//  criar o model de fornecedor
private Long idFornecedor;

// criar um model onde cadastro as minhas lojas
private Long enviarParaLoja;

// pagamento em dinehiro na entrega
// pagamento no recebimento
// pagamento antecipado
// 7 dias da data liquida
// 7 dias da data liquida
// 15 dias da data liquida
// 30 dias da data liquida
// 45 dias da data liquida
// 60 dias da data liquida
private String condicoesPagamento;



// INFORMACOES DA REMESSA
private LocalDateTime chegadaEstimada;

// criar model da transportaadora
private Long idTransportadora;
private String numeroDeRastreamento;


// INFORMACOES ADICIONAIS
private String numeroDeReferencia;
private String informacoesParaOFornecedor;
private List<String> tags;

// RESUMO DE CUSTOS
private List<ProductModel> products;
    // vao vir dos dados dos produtos inseridos
    private Long tributos ;
    private Long subtotal ;
    private Long frete ;
    private Long total ;
}
