package io.autorune.updater.analyzer.classes.implementations.audio.pcm

import io.autorune.updater.analyzer.classes.ClassAnalyzer
import io.autorune.updater.analyzer.classes.annotations.CorrectFieldCount
import io.autorune.updater.analyzer.classes.annotations.CorrectMethodCount
import io.autorune.updater.analyzer.classes.annotations.DependsOn
import io.autorune.updater.analyzer.classes.implementations.collection.Node
import org.objectweb.asm.tree.ClassNode
import java.lang.reflect.Modifier

@CorrectFieldCount(0)
@CorrectMethodCount(0)
@DependsOn(Node::class)
class PcmStream : ClassAnalyzer() {

    override fun findClassNode(): ClassNode? {
        for (classNode in classPool) {

            if (classNode.superName != getClassAnalyser(Node::class)?.classNode?.name)
                continue

            val match = classNode.methods.count { it.desc == "([III)V" && Modifier.isAbstract(it.access) } == 1

            if (!match)
                continue

            return classNode

        }
        return null
    }

    override fun getFields() {

    }

}