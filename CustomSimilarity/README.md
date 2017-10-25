# CustomSimilarity

## schema定義

* 下記を追記
```
<similarity class="solr.SchemaSimilarityFactory"/>
```
* fieldType毎に定義
```
<similarity class="com.kakaku.solr.search.similarities.IgnoreTfIdfSimilarityFactory">
  <str name="ignoreTfFlg">true</str>
  <str name="ignoreIdfFlg">true</str>
</similarity>
```

* パラメータ補足
  * ignoreTfFlg  
  trueでTF値として固定値(1.0)を返却
  * ignoreIdfFlg  
  trueでIDF値として固定値(1.0)を返却
