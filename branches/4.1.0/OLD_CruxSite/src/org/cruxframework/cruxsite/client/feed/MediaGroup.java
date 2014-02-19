package org.cruxframework.cruxsite.client.feed;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class MediaGroup extends JavaScriptObject
{
	protected MediaGroup() {}
	
	public final native JsArray<MediaContent> getMediaContents()/*-{
		return this.contents;
	}-*/;
}
/*

{"responseData": 
    {"feed":
    	{"feedUrl":"http://feeds.feedburner.com/liveware/rssgdget/youtube/tvgalo","title":"Uploads by tvgaloweb","link":"http://www.youtube.com/profile_videos?user\u003dtvgaloweb","author":"","description":"","type":"rss20",
	     "entries":[
	                {"mediaGroups":[
	                                {"contents":[
	                                             {"url":"http://www.youtube.com/v/AufAmpVPV0E?f\u003duser_uploads\u0026app\u003dyoutube_gdata",
	                                              "type":"application/x-shockwave-flash",
	                                              "medium":"video",
	                                              "isDefault":"true",
	                                              "expression":"full",
	                                              "duration":150.0,
	                                              "title":"19/09/2011 Atlético inicia preparação para enfrentar o Flamengo",
	                                              "description":"O elenco atleticano se reapresentou na tarde desta segunda-feira, na Cidade do Galo, e iniciou a preparação para o jogo contra o Flamengo, pela 25ª rodada do Campeonato Brasileiro. A partida será realizada às 21h50 desta quarta-feira, na Arena do Jacaré, em Sete Lagoas.\n\nOs atletas que atuaram em Goiânia fizeram atividades físicas na academia e os demais participaram de um coletivo com atletas do time juvenil.\n\nO atacante André, recuperado de uma entorse no tornozelo esquerdo, participou normalmente do treino. A equipe treinou com Lee; Mancini, Lima, Luiz Eduardo e Eron; Gilberto, Dudu Cearense, Renan Oliveira e Wesley; André e Jonatas Obina.\n\nRecuperado de um leve estiramento muscular na região anterior da coxa direita, o atacante Magno Alves está liberado pelo departamento médico e realizou exercícios físicos.\n\nO atacante Neto Berola, que se contundiu no último jogo após sofrer uma entrada dura do zagueiro do Atlético-GO, segue com o tornozelo direito bastante inchado e está vetado para o confronto desta quarta-feira.\n\n\"O Neto Berola sofreu uma entorse no tornozelo direito, decorrente de uma pancada na perna, com escoriações. Ele foi submetido a uma radiografia que não mostrou nenhuma lesão\", informou o médico Otaviano Oliveira.\n\nJá o zagueiro Réver foi submetido a uma ressonância magnética na tarde desta segunda-feira e o exame apontou uma contusão no joelho direito.\n\n\"A ressonância mostrou um edema ósseo e, felizmente, não houve nenhuma lesão ligamentar ou de menisco\", observou Otaviano Oliveira.",
	                                              "keywords":["Clube","Atlético","Mineiro","TV","Galo","André","Renan","Oliveira","Otaviano","Júnior"],
	                                              "thumbnails":[
	                                                            {"height":360,"width":480,"url":"http://i.ytimg.com/vi/AufAmpVPV0E/0.jpg","time":"00:01:15"},
	                                                            {"height":90,"width":120,"url":"http://i.ytimg.com/vi/AufAmpVPV0E/1.jpg","time":"00:00:37.500"},
	                                                            {"height":90,"width":120,"url":"http://i.ytimg.com/vi/AufAmpVPV0E/2.jpg","time":"00:01:15"},
	                                                            {"height":90,"width":120,"url":"http://i.ytimg.com/vi/AufAmpVPV0E/3.jpg","time":"00:01:52.500"}
	                                                            ],
	                                              "categories":[
	                                                            {"scheme":"http://gdata.youtube.com/schemas/2007/categories.cat","label":"Sports","content":"Sports"}
	                                                            ],
	                                              "player":{"url":"http://www.youtube.com/watch?v\u003dAufAmpVPV0E\u0026feature\u003dyoutube_gdata_player"}
	                                             },
	                                             {"url":"rtsp://v8.cache4.c.youtube.com/CigLENy73wIaHwlBV0-VmsDnAhMYDSANFEgGUgx1c2VyX3VwbG9hZHMM/0/0/0/video.3gp",
	                                              "type":"video/3gpp",
	                                              "medium":"video",
	                                              "expression":"full",
	                                              "duration":150.0,
	                                              "title":"19/09/2011 Atlético inicia preparação para enfrentar o Flamengo",
	                                              "description":"O elenco atleticano se reapresentou na tarde desta segunda-feira, na Cidade do Galo, e iniciou a preparação para o jogo contra o Flamengo, pela 25ª rodada do Campeonato Brasileiro. A partida será realizada às 21h50 desta quarta-feira, na Arena do Jacaré, em Sete Lagoas.\n\nOs atletas que atuaram em Goiânia fizeram atividades físicas na academia e os demais participaram de um coletivo com atletas do time juvenil.\n\nO atacante André, recuperado de uma entorse no tornozelo esquerdo, participou normalmente do treino. A equipe treinou com Lee; Mancini, Lima, Luiz Eduardo e Eron; Gilberto, Dudu Cearense, Renan Oliveira e Wesley; André e Jonatas Obina.\n\nRecuperado de um leve estiramento muscular na região anterior da coxa direita, o atacante Magno Alves está liberado pelo departamento médico e realizou exercícios físicos.\n\nO atacante Neto Berola, que se contundiu no último jogo após sofrer uma entrada dura do zagueiro do Atlético-GO, segue com o tornozelo direito bastante inchado e está vetado para o confronto desta quarta-feira.\n\n\"O Neto Berola sofreu uma entorse no tornozelo direito, decorrente de uma pancada na perna, com escoriações. Ele foi submetido a uma radiografia que não mostrou nenhuma lesão\", informou o médico Otaviano Oliveira.\n\nJá o zagueiro Réver foi submetido a uma ressonância magnética na tarde desta segunda-feira e o exame apontou uma contusão no joelho direito.\n\n\"A ressonância mostrou um edema ósseo e, felizmente, não houve nenhuma lesão ligamentar ou de menisco\", observou Otaviano Oliveira.",
	                                              "keywords":["Clube","Atlético","Mineiro","TV","Galo","André","Renan","Oliveira","Otaviano","Júnior"],
	                                              "thumbnails":[
	                                                            {"height":360,"width":480,"url":"http://i.ytimg.com/vi/AufAmpVPV0E/0.jpg","time":"00:01:15"},
	                                                            {"height":90,"width":120,"url":"http://i.ytimg.com/vi/AufAmpVPV0E/1.jpg","time":"00:00:37.500"},
	                                                            {"height":90,"width":120,"url":"http://i.ytimg.com/vi/AufAmpVPV0E/2.jpg","time":"00:01:15"},
	                                                            {"height":90,"width":120,"url":"http://i.ytimg.com/vi/AufAmpVPV0E/3.jpg","time":"00:01:52.500"}
	                                                            ],
	                                              "categories":[{"scheme":"http://gdata.youtube.com/schemas/2007/categories.cat","label":"Sports","content":"Sports"}],
	                                              "player":{"url":"http://www.youtube.com/watch?v\u003dAufAmpVPV0E\u0026feature\u003dyoutube_gdata_player"}
	                                             },
	                                             {"url":"rtsp://v3.cache7.c.youtube.com/CigLENy73wIaHwlBV0-VmsDnAhMYESARFEgGUgx1c2VyX3VwbG9hZHMM/0/0/0/video.3gp",
	                                              "type":"video/3gpp",
	                                              "medium":"video",
	                                              "expression":"full",
	                                              "duration":150.0,
	                                              "title":"19/09/2011 Atlético inicia preparação para enfrentar o Flamengo",
	                                              "description":"O elenco atleticano se reapresentou na tarde desta segunda-feira, na Cidade do Galo, e iniciou a preparação para o jogo contra o Flamengo, pela 25ª rodada do Campeonato Brasileiro. A partida será realizada às 21h50 desta quarta-feira, na Arena do Jacaré, em Sete Lagoas.\n\nOs atletas que atuaram em Goiânia fizeram atividades físicas na academia e os demais participaram de um coletivo com atletas do time juvenil.\n\nO atacante André, recuperado de uma entorse no tornozelo esquerdo, participou normalmente do treino. A equipe treinou com Lee; Mancini, Lima, Luiz Eduardo e Eron; Gilberto, Dudu Cearense, Renan Oliveira e Wesley; André e Jonatas Obina.\n\nRecuperado de um leve estiramento muscular na região anterior da coxa direita, o atacante Magno Alves está liberado pelo departamento médico e realizou exercícios físicos.\n\nO atacante Neto Berola, que se contundiu no último jogo após sofrer uma entrada dura do zagueiro do Atlético-GO, segue com o tornozelo direito bastante inchado e está vetado para o confronto desta quarta-feira.\n\n\"O Neto Berola sofreu uma entorse no tornozelo direito, decorrente de uma pancada na perna, com escoriações. Ele foi submetido a uma radiografia que não mostrou nenhuma lesão\", informou o médico Otaviano Oliveira.\n\nJá o zagueiro Réver foi submetido a uma ressonância magnética na tarde desta segunda-feira e o exame apontou uma contusão no joelho direito.\n\n\"A ressonância mostrou um edema ósseo e, felizmente, não houve nenhuma lesão ligamentar ou de menisco\", observou Otaviano Oliveira.",
	                                              "keywords":["Clube","Atlético","Mineiro","TV","Galo","André","Renan","Oliveira","Otaviano","Júnior"],
	                                              "thumbnails":[
	                                                            {"height":360,"width":480,"url":"http://i.ytimg.com/vi/AufAmpVPV0E/0.jpg","time":"00:01:15"},
	                                                            {"height":90,"width":120,"url":"http://i.ytimg.com/vi/AufAmpVPV0E/1.jpg","time":"00:00:37.500"},
	                                                            {"height":90,"width":120,"url":"http://i.ytimg.com/vi/AufAmpVPV0E/2.jpg","time":"00:01:15"},
	                                                            {"height":90,"width":120,"url":"http://i.ytimg.com/vi/AufAmpVPV0E/3.jpg","time":"00:01:52.500"}
	                                                            ],
	                                              "categories":[{"scheme":"http://gdata.youtube.com/schemas/2007/categories.cat","label":"Sports","content":"Sports"}],
	                                              "player":{"url":"http://www.youtube.com/watch?v\u003dAufAmpVPV0E\u0026feature\u003dyoutube_gdata_player"}
	                                             }
	                                            ]
	                                  }
	                                ],
	                  "title":"19/09/2011 Atlético inicia preparação para enfrentar o Flamengo",
	                  "link":"http://www.youtube.com/watch?v\u003dAufAmpVPV0E\u0026feature\u003dyoutube_gdata",
	                  "author":"tvgaloweb",
	                  "publishedDate":"Mon, 19 Sep 2011 16:27:06 -0700",
	                  "contentSnippet":"O elenco atleticano se reapresentou na tarde desta segunda-feira, na Cidade do Galo, e iniciou a preparação para o jogo contra ...",
	                  "content":"O elenco atleticano se reapresentou na tarde desta segunda-feira, na Cidade do Galo, e iniciou a preparação para o jogo contra o Flamengo, pela 25ª rodada do Campeonato Brasileiro. A partida será realizada às 21h50 desta quarta-feira, na Arena do Jacaré, em Sete Lagoas.\n\nOs atletas que atuaram em Goiânia fizeram atividades físicas na academia e os demais participaram de um coletivo com atletas do time juvenil.\n\nO atacante André, recuperado de uma entorse no tornozelo esquerdo, participou normalmente do treino. A equipe treinou com Lee; Mancini, Lima, Luiz Eduardo e Eron; Gilberto, Dudu Cearense, Renan Oliveira e Wesley; André e Jonatas Obina.\n\nRecuperado de um leve estiramento muscular na região anterior da coxa direita, o atacante Magno Alves está liberado pelo departamento médico e realizou exercícios físicos.\n\nO atacante Neto Berola, que se contundiu no último jogo após sofrer uma entrada dura do zagueiro do Atlético-GO, segue com o tornozelo direito bastante inchado e está vetado para o confronto desta quarta-feira.\n\n\"O Neto Berola sofreu uma entorse no tornozelo direito, decorrente de uma pancada na perna, com escoriações. Ele foi submetido a uma radiografia que não mostrou nenhuma lesão\", informou o médico Otaviano Oliveira.\n\nJá o zagueiro Réver foi submetido a uma ressonância magnética na tarde desta segunda-feira e o exame apontou uma contusão no joelho direito.\n\n\"A ressonância mostrou um edema ósseo e, felizmente, não houve nenhuma lesão ligamentar ou de menisco\", observou Otaviano Oliveira.",
	                  "categories":["http://gdata.youtube.com/schemas/2007#video","Sports","Clube","Atlético","Mineiro","TV","Galo","André","Renan","Oliveira","Otaviano","Júnior"]
	                  }
	                ,
	                {"mediaGroups":[{"contents":[{"url":"http://www.youtube.com/v/BIh72jLbjbI?f\u003duser_uploads\u0026app\u003dyoutube_gdata","type":"application/x-shockwave-flash","medium":"video","isDefault":"true","expression":"full","duration":352.0,"title":"19/09/2011 Entrevista Coletiva: André","description":"Confira a entrevista coletiva.","keywords":["Clube","Atlético","Mineiro","TV","Galo","André"],"thumbnails":[{"height":360,"width":480,"url":"http://i.ytimg.com/vi/BIh72jLbjbI/0.jpg","time":"00:02:56"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/BIh72jLbjbI/1.jpg","time":"00:01:28"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/BIh72jLbjbI/2.jpg","time":"00:02:56"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/BIh72jLbjbI/3.jpg","time":"00:04:24"}],"categories":[{"scheme":"http://gdata.youtube.com/schemas/2007/categories.cat","label":"Sports","content":"Sports"}],"player":{"url":"http://www.youtube.com/watch?v\u003dBIh72jLbjbI\u0026feature\u003dyoutube_gdata_player"}},{"url":"rtsp://v1.cache5.c.youtube.com/CigLENy73wIaHwmyjdsy2nuIBBMYDSANFEgGUgx1c2VyX3VwbG9hZHMM/0/0/0/video.3gp","type":"video/3gpp","medium":"video","expression":"full","duration":352.0,"title":"19/09/2011 Entrevista Coletiva: André","description":"Confira a entrevista coletiva.","keywords":["Clube","Atlético","Mineiro","TV","Galo","André"],"thumbnails":[{"height":360,"width":480,"url":"http://i.ytimg.com/vi/BIh72jLbjbI/0.jpg","time":"00:02:56"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/BIh72jLbjbI/1.jpg","time":"00:01:28"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/BIh72jLbjbI/2.jpg","time":"00:02:56"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/BIh72jLbjbI/3.jpg","time":"00:04:24"}],"categories":[{"scheme":"http://gdata.youtube.com/schemas/2007/categories.cat","label":"Sports","content":"Sports"}],"player":{"url":"http://www.youtube.com/watch?v\u003dBIh72jLbjbI\u0026feature\u003dyoutube_gdata_player"}},{"url":"rtsp://v5.cache5.c.youtube.com/CigLENy73wIaHwmyjdsy2nuIBBMYESARFEgGUgx1c2VyX3VwbG9hZHMM/0/0/0/video.3gp","type":"video/3gpp","medium":"video","expression":"full","duration":352.0,"title":"19/09/2011 Entrevista Coletiva: André","description":"Confira a entrevista coletiva.","keywords":["Clube","Atlético","Mineiro","TV","Galo","André"],"thumbnails":[{"height":360,"width":480,"url":"http://i.ytimg.com/vi/BIh72jLbjbI/0.jpg","time":"00:02:56"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/BIh72jLbjbI/1.jpg","time":"00:01:28"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/BIh72jLbjbI/2.jpg","time":"00:02:56"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/BIh72jLbjbI/3.jpg","time":"00:04:24"}],"categories":[{"scheme":"http://gdata.youtube.com/schemas/2007/categories.cat","label":"Sports","content":"Sports"}],"player":{"url":"http://www.youtube.com/watch?v\u003dBIh72jLbjbI\u0026feature\u003dyoutube_gdata_player"}}]}],"title":"19/09/2011 Entrevista Coletiva: André","link":"http://www.youtube.com/watch?v\u003dBIh72jLbjbI\u0026feature\u003dyoutube_gdata","author":"tvgaloweb","publishedDate":"Mon, 19 Sep 2011 16:29:14 -0700","contentSnippet":"Confira a entrevista coletiva.","content":"Confira a entrevista coletiva.","categories":["http://gdata.youtube.com/schemas/2007#video","Sports","Clube","Atlético","Mineiro","TV","Galo","André"]},{"mediaGroups":[{"contents":[{"url":"http://www.youtube.com/v/aI-BbANyoHg?f\u003duser_uploads\u0026app\u003dyoutube_gdata","type":"application/x-shockwave-flash","medium":"video","isDefault":"true","expression":"full","duration":403.0,"title":"19/09/2011 Entrevista Coletiva: Renan Oliveira","description":"Confira a entrevista coletiva.","keywords":["Clube","Atlético","Mineiro","TV","Galo","Renan","Oliveira"],"thumbnails":[{"height":360,"width":480,"url":"http://i.ytimg.com/vi/aI-BbANyoHg/0.jpg","time":"00:03:21.500"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/aI-BbANyoHg/1.jpg","time":"00:01:40.750"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/aI-BbANyoHg/2.jpg","time":"00:03:21.500"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/aI-BbANyoHg/3.jpg","time":"00:05:02.250"}],"categories":[{"scheme":"http://gdata.youtube.com/schemas/2007/categories.cat","label":"Sports","content":"Sports"}],"player":{"url":"http://www.youtube.com/watch?v\u003daI-BbANyoHg\u0026feature\u003dyoutube_gdata_player"}},{"url":"rtsp://v3.cache8.c.youtube.com/CigLENy73wIaHwl4oHIDbIGPaBMYDSANFEgGUgx1c2VyX3VwbG9hZHMM/0/0/0/video.3gp","type":"video/3gpp","medium":"video","expression":"full","duration":403.0,"title":"19/09/2011 Entrevista Coletiva: Renan Oliveira","description":"Confira a entrevista coletiva.","keywords":["Clube","Atlético","Mineiro","TV","Galo","Renan","Oliveira"],"thumbnails":[{"height":360,"width":480,"url":"http://i.ytimg.com/vi/aI-BbANyoHg/0.jpg","time":"00:03:21.500"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/aI-BbANyoHg/1.jpg","time":"00:01:40.750"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/aI-BbANyoHg/2.jpg","time":"00:03:21.500"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/aI-BbANyoHg/3.jpg","time":"00:05:02.250"}],"categories":[{"scheme":"http://gdata.youtube.com/schemas/2007/categories.cat","label":"Sports","content":"Sports"}],"player":{"url":"http://www.youtube.com/watch?v\u003daI-BbANyoHg\u0026feature\u003dyoutube_gdata_player"}},{"url":"rtsp://v8.cache3.c.youtube.com/CigLENy73wIaHwl4oHIDbIGPaBMYESARFEgGUgx1c2VyX3VwbG9hZHMM/0/0/0/video.3gp","type":"video/3gpp","medium":"video","expression":"full","duration":403.0,"title":"19/09/2011 Entrevista Coletiva: Renan Oliveira","description":"Confira a entrevista coletiva.","keywords":["Clube","Atlético","Mineiro","TV","Galo","Renan","Oliveira"],"thumbnails":[{"height":360,"width":480,"url":"http://i.ytimg.com/vi/aI-BbANyoHg/0.jpg","time":"00:03:21.500"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/aI-BbANyoHg/1.jpg","time":"00:01:40.750"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/aI-BbANyoHg/2.jpg","time":"00:03:21.500"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/aI-BbANyoHg/3.jpg","time":"00:05:02.250"}],"categories":[{"scheme":"http://gdata.youtube.com/schemas/2007/categories.cat","label":"Sports","content":"Sports"}],"player":{"url":"http://www.youtube.com/watch?v\u003daI-BbANyoHg\u0026feature\u003dyoutube_gdata_player"}}]}],"title":"19/09/2011 Entrevista Coletiva: Renan Oliveira","link":"http://www.youtube.com/watch?v\u003daI-BbANyoHg\u0026feature\u003dyoutube_gdata","author":"tvgaloweb","publishedDate":"Mon, 19 Sep 2011 16:29:35 -0700","contentSnippet":"Confira a entrevista coletiva.","content":"Confira a entrevista coletiva.","categories":["http://gdata.youtube.com/schemas/2007#video","Sports","Clube","Atlético","Mineiro","TV","Galo","Renan","Oliveira"]},{"mediaGroups":[{"contents":[{"url":"http://www.youtube.com/v/t9C3HRHDyJY?f\u003duser_uploads\u0026app\u003dyoutube_gdata","type":"application/x-shockwave-flash","medium":"video","isDefault":"true","expression":"full","duration":112.0,"title":"16/09/2011  Presidente Alexandre Kalil prestigia solenidade de mil dias para a Copa","description":"O presidente do Atlético, Alexandre Kalil, prestigiou a solenidade oficial que marcou o início da contagem regressiva de mil dias para a Copa do Mundo de 2014.\n\nO evento foi realizado na noite desta sexta-feira, no Palácio da Liberdade, em Belo Horizonte, e foi marcado pela inauguração de um relógio de oito metros de altura, que fará a contagem regressiva para o Mundial no Brasil.\n\nO governador do Estado de Minas Gerais, Antônio Anastasia, recebeu no Palácio da Liberdade o presidente da Confederação Brasileira de Futebol (CBF), Ricardo Teixeira, o prefeito de Belo Horizonte, Márcio Lacerda, e o ministro do Esporte, Orlando Silva, entre outras personalidades.","keywords":["Clube","Atlético","Mineiro","TV","Galo","Alexandre","Kalil","doido","time","júnior"],"thumbnails":[{"height":360,"width":480,"url":"http://i.ytimg.com/vi/t9C3HRHDyJY/0.jpg","time":"00:00:56"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/t9C3HRHDyJY/1.jpg","time":"00:00:28"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/t9C3HRHDyJY/2.jpg","time":"00:00:56"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/t9C3HRHDyJY/3.jpg","time":"00:01:24"}],"categories":[{"scheme":"http://gdata.youtube.com/schemas/2007/categories.cat","label":"Sports","content":"Sports"}],"player":{"url":"http://www.youtube.com/watch?v\u003dt9C3HRHDyJY\u0026feature\u003dyoutube_gdata_player"}},{"url":"rtsp://v6.cache7.c.youtube.com/CigLENy73wIaHwmWyMMRHbfQtxMYDSANFEgGUgx1c2VyX3VwbG9hZHMM/0/0/0/video.3gp","type":"video/3gpp","medium":"video","expression":"full","duration":112.0,"title":"16/09/2011  Presidente Alexandre Kalil prestigia solenidade de mil dias para a Copa","description":"O presidente do Atlético, Alexandre Kalil, prestigiou a solenidade oficial que marcou o início da contagem regressiva de mil dias para a Copa do Mundo de 2014.\n\nO evento foi realizado na noite desta sexta-feira, no Palácio da Liberdade, em Belo Horizonte, e foi marcado pela inauguração de um relógio de oito metros de altura, que fará a contagem regressiva para o Mundial no Brasil.\n\nO governador do Estado de Minas Gerais, Antônio Anastasia, recebeu no Palácio da Liberdade o presidente da Confederação Brasileira de Futebol (CBF), Ricardo Teixeira, o prefeito de Belo Horizonte, Márcio Lacerda, e o ministro do Esporte, Orlando Silva, entre outras personalidades.","keywords":["Clube","Atlético","Mineiro","TV","Galo","Alexandre","Kalil","doido","time","júnior"],"thumbnails":[{"height":360,"width":480,"url":"http://i.ytimg.com/vi/t9C3HRHDyJY/0.jpg","time":"00:00:56"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/t9C3HRHDyJY/1.jpg","time":"00:00:28"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/t9C3HRHDyJY/2.jpg","time":"00:00:56"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/t9C3HRHDyJY/3.jpg","time":"00:01:24"}],"categories":[{"scheme":"http://gdata.youtube.com/schemas/2007/categories.cat","label":"Sports","content":"Sports"}],"player":{"url":"http://www.youtube.com/watch?v\u003dt9C3HRHDyJY\u0026feature\u003dyoutube_gdata_player"}},{"url":"rtsp://v4.cache2.c.youtube.com/CigLENy73wIaHwmWyMMRHbfQtxMYESARFEgGUgx1c2VyX3VwbG9hZHMM/0/0/0/video.3gp","type":"video/3gpp","medium":"video","expression":"full","duration":112.0,"title":"16/09/2011  Presidente Alexandre Kalil prestigia solenidade de mil dias para a Copa","description":"O presidente do Atlético, Alexandre Kalil, prestigiou a solenidade oficial que marcou o início da contagem regressiva de mil dias para a Copa do Mundo de 2014.\n\nO evento foi realizado na noite desta sexta-feira, no Palácio da Liberdade, em Belo Horizonte, e foi marcado pela inauguração de um relógio de oito metros de altura, que fará a contagem regressiva para o Mundial no Brasil.\n\nO governador do Estado de Minas Gerais, Antônio Anastasia, recebeu no Palácio da Liberdade o presidente da Confederação Brasileira de Futebol (CBF), Ricardo Teixeira, o prefeito de Belo Horizonte, Márcio Lacerda, e o ministro do Esporte, Orlando Silva, entre outras personalidades.","keywords":["Clube","Atlético","Mineiro","TV","Galo","Alexandre","Kalil","doido","time","júnior"],"thumbnails":[{"height":360,"width":480,"url":"http://i.ytimg.com/vi/t9C3HRHDyJY/0.jpg","time":"00:00:56"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/t9C3HRHDyJY/1.jpg","time":"00:00:28"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/t9C3HRHDyJY/2.jpg","time":"00:00:56"},{"height":90,"width":120,"url":"http://i.ytimg.com/vi/t9C3HRHDyJY/3.jpg","time":"00:01:24"}],"categories":[{"scheme":"http://gdata.youtube.com/schemas/2007/categories.cat","label":"Sports","content":"Sports"}],"player":{"url":"http://www.youtube.com/watch?v\u003dt9C3HRHDyJY\u0026feature\u003dyoutube_gdata_player"}}]}],"title":"16/09/2011  Presidente Alexandre Kalil prestigia solenidade de mil dias para a Copa","link":"http://www.youtube.com/watch?v\u003dt9C3HRHDyJY\u0026feature\u003dyoutube_gdata","author":"tvgaloweb","publishedDate":"Fri, 16 Sep 2011 19:02:57 -0700","contentSnippet":"O presidente do Atlético, Alexandre Kalil, prestigiou a solenidade oficial que marcou o início da contagem regressiva de mil ...","content":"O presidente do Atlético, Alexandre Kalil, prestigiou a solenidade oficial que marcou o início da contagem regressiva de mil dias para a Copa do Mundo de 2014.\n\nO evento foi realizado na noite desta sexta-feira, no Palácio da Liberdade, em Belo Horizonte, e foi marcado pela inauguração de um relógio de oito metros de altura, que fará a contagem regressiva para o Mundial no Brasil.\n\nO governador do Estado de Minas Gerais, Antônio Anastasia, recebeu no Palácio da Liberdade o presidente da Confederação Brasileira de Futebol (CBF), Ricardo Teixeira, o prefeito de Belo Horizonte, Márcio Lacerda, e o ministro do Esporte, Orlando Silva, entre outras personalidades.","categories":["http://gdata.youtube.com/schemas/2007#video","Sports","Clube","Atlético","Mineiro","TV","Galo","Alexandre","Kalil","doido","time","júnior"]}]}}, "responseDetails": null, "responseStatus": 200}

*/